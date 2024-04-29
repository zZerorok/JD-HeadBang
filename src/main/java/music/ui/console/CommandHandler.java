package music.ui.console;

import java.util.HashMap;
import music.application.CartService;
import music.comparable.sort.track.*;
import music.comparable.sort.track50.AscArtistName;
import music.comparable.sort.track50.AscReleaseDate;
import music.comparable.sort.track50.AscTrackName;
import music.comparable.sort.track50.DescArtistName;
import music.comparable.sort.track50.DescReleaseDate;
import music.comparable.sort.track50.DescTrackName;
import music.domain.Search;
import music.domain.dto.TrackDTO;
import music.domain.MyAlbum;
import music.infrastructure.CartInMemoryRepository;
import music.service.Database;
import music.ui.console.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;

public class CommandHandler {
    private final CartController cartController;
    private final PrintList pl = new PrintList();
    List<TrackDTO> result = new ArrayList<>();


    private Database db = new Database();
    private Search sh = new Search();
    private final MyAlbum myAlbum = new MyAlbum();
    private long money;

    public CommandHandler() {
        CartService cartService = new CartService(new CartInMemoryRepository(), db);
        cartController = new CartController(cartService);
        money = 100000;
    }

    public static void emoji(){
        System.out.println("⭐〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️⭐");
    }

    public void run() {
        // 메인메뉴 커맨드
        System.out.println("🎤🎵🪩반갑습니다, 헤드뱅뱅뮤직스토어에 오신 것을 환영합니다!🎤🎵🪩");
        emoji();
        for (Command command : Command.values()) {
            System.out.println(command.getCode() + ". " + command.getTitle());
        }
        emoji();
        String inputCommand = InputUtils.nextLine("원하는 메뉴를 입력하세요 ");
        emoji();
        Command command = Command.from(inputCommand);

        switch (command) {
            case SEARCH_ALBUM -> {
                for (SearchCommand search_Command : SearchCommand.values()) {
                    System.out.println(search_Command.getCode() + ". " + search_Command.getTitle());
                }
                emoji();
                String inputSearchCommand = InputUtils.nextLine("메뉴를 입력하세요 ");
                emoji();
                SearchCommand command2 = SearchCommand.from(inputSearchCommand);

                switch (command2) {
                    case SHOW_ALBUM -> {
//                        System.out.println("🎙️ TOP50 곡 목록입니다~!");
//                        pl.displayTopTracks(sh.searchTop50());

                        for (SongCommand song_Command : SongCommand.values()) {
                            System.out.println(song_Command.getCode() + ". " + song_Command.getTitle());
                        }

                        String inputSongCommand = InputUtils.nextLine("메뉴를 입력하세요 ");
                        SongCommand command3 = SongCommand.from(inputSongCommand);

                        switch (command3) {
                            case SORT -> {
                                //정렬 메뉴 출력
                                for (SortCommand sort_Command : SortCommand.values()) {
                                    System.out.println(sort_Command.getCode() + ". " + sort_Command.getTitle());
                                }
                                String inputsortCommand = InputUtils.nextLine("메뉴를 입력하세요 ");
                                SortCommand command4 = SortCommand.from(inputsortCommand);
                                switch (command4) {
                                    case RELEASEDATE_ASC -> {
                                        System.out.println("🔎 발매일이 오래된순부터 조회하기");
                                        List<HashMap<String, String>> sortedTracks = sh.searchTop50();
                                        sortedTracks.sort(new DescReleaseDate());
                                        pl.displayTopTracks(sortedTracks);

                                    }
                                    case RELEASEDATE_DESC -> {
                                        System.out.println("🔎 발매일이 최신순부터 조회하기");
                                        List<HashMap<String, String>> sortedTracks = sh.searchTop50();
                                        sortedTracks.sort(new AscReleaseDate());
                                        pl.displayTopTracks(sortedTracks);

                                    }
                                    case ARTISTNAME_DESC -> {
                                        System.out.println("🔎 가수이름 가나다순으로 조회하기");
                                        List<HashMap<String, String>> sortedTracks = sh.searchTop50();
                                        sortedTracks.sort(new DescArtistName());
                                        pl.displayTopTracks(sortedTracks);

                                    }

                                    case ARTISTNAME_ASC -> {
                                        System.out.println("🔎 가수이름 역순으로 조회하기");
                                        List<HashMap<String, String>> sortedTracks = sh.searchTop50();
                                        sortedTracks.sort(new AscArtistName());
                                        pl.displayTopTracks(sortedTracks);

                                    }
                                    case NAME_DESC -> {
                                        System.out.println("🔎 곡명 가나다순으로 조회하기");
                                        List<HashMap<String, String>> sortedTracks = sh.searchTop50();
                                        sortedTracks.sort(new DescTrackName());
                                        pl.displayTopTracks(sortedTracks);
                                    }
                                    case NAME_ASC -> {
                                        System.out.println("🔎 곡명 역순으로 조회하기");
                                        List<HashMap<String, String>> sortedTracks = sh.searchTop50();
                                        sortedTracks.sort(new AscTrackName());
                                        pl.displayTopTracks(sortedTracks);
                                    }

                                    case EXIT -> {
                                        System.out.println("메인메뉴로 돌아갑니다");
                                    }
                                }
                            }
                        }
                    }
                    case TOTAL_SEARCH -> {
                        System.out.print("검색어를 입력해주세요 : ");
                        String search = InputUtils.nextLine();

                        result = sh.searchTracks(search); //TODO 다빈 : 가수 내림차순 정렬
                        result.sort(new music.comparable.sort.track.DescArtistName());
                        pl.printTrack(result);
                        System.out.print("번호를 선택해주세요 : ");
                        String number = InputUtils.nextLine();
                        for (int i = 0; i < result.size(); i++) {
                            if ((Integer.parseInt(number) - 1) == i) {
                                pl.printAlbum(sh.searchAlbum(result.get(i).getCollectionId()));
                            }
                        }
                    }
                    case EXIT -> {
                        System.out.println("메인메뉴로 돌아갑니다");
                    }
                }
            }
            case CART -> {
                cartController.showCart();
                for (PurchaseCommand purchase_Command : PurchaseCommand.values()) {
                    System.out.println(purchase_Command.getCode() + ". " + purchase_Command.getTitle());
                }

                String inputCartCommand = InputUtils.nextLine("장바구니 메뉴를 입력해 주세요.");
                PurchaseCommand cartCommand = PurchaseCommand.from(inputCartCommand);

                switch (cartCommand) {
                    case PUT -> cartController.put();
                    case CANCEL -> cartController.cancel();
                    case CHANGE_AMOUNT -> {
                        System.out.println("수량을 변경합니다.");
                        cartController.update();
                    }
                    case PURCHASE -> {
                        System.out.println("장바구니에 담은 앨범을 구매합니다.");
                        int totalPrice = cartController.getTotalPrice(); // 장바구니에 담긴 앨범들의 총 금액
                        if (money >= totalPrice) {
                            cartController.buy(myAlbum, db);
                            money -= totalPrice;
                        }
                    }
                    case EXIT -> {
                        System.out.println("메인메뉴로 돌아갑니다.");
                    }
                }
            }
            case EXIT -> {
                System.out.println("종료합니다.");
                System.exit(0);
            }
        }
    }
}


