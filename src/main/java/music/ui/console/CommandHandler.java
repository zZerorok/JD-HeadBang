package music.ui.console;

import music.application.CartService;
import music.comparable.sort.track.*;
import music.domain.CartRepository;
import music.domain.MyAlbum;
import music.domain.Search;
import music.domain.dto.TrackDTO;
import music.domain.dto.User;
import music.infrastructure.CartInMemoryRepository;
import music.infrastructure.Carts;
import music.infrastructure.MyAlbums;
import music.infrastructure.UserInMemoryRepository;
import music.service.AudioPlayer;
import music.ui.console.utils.InputUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CommandHandler {
    private CartController cartController;
    private final PrintList pl = new PrintList();
    private final Search sh = new Search();
    private MyAlbum myAlbum;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private List<TrackDTO> result = new ArrayList<>();
    private long money;
    private final UserInMemoryRepository userInMemoryRepository = new UserInMemoryRepository();
    private final Carts carts = new Carts();
    private final MyAlbums myAlbums = new MyAlbums();

    public CommandHandler() {
        CartService cartService = new CartService(new CartInMemoryRepository(), sh);
        cartController = new CartController(cartService);
        money = 100000;
    }

    public static void emoji() {
        System.out.println("⭐〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️〰️⭐");
    }

    public void run() {
        // 메인메뉴 커맨드
        System.out.println("🎤🎵🪩반갑습니다, 헤드뱅뱅뮤직스토어에 오신 것을 환영합니다!🎤🎵🪩");
        emoji();

        boolean isLogin = false;

        while(true) {
            while(!isLogin) {
                for (UserCommand command : UserCommand.values()) {
                    System.out.println(command.getCode() + ". " + command.getTitle());
                }
                emoji();
                String inputCommand = InputUtils.nextLine("원하는 메뉴를 입력하세요 ");
                emoji();
                UserCommand command = UserCommand.from(inputCommand);
                switch (command) {
                    case SIGN_UP -> signUp();
                    case LOGIN -> isLogin = tryLogin();
                }
            }

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
                                            List<TrackDTO> sortedTracks = sh.searchTop50();
                                            sortedTracks.sort(new DescReleaseDate());
                                            pl.displayTopTracks(sortedTracks);

                                        }
                                        case RELEASEDATE_DESC -> {
                                            System.out.println("🔎 발매일이 최신순부터 조회하기");
                                            List<TrackDTO> sortedTracks = sh.searchTop50();
                                            sortedTracks.sort(new AscReleaseDate());
                                            pl.displayTopTracks(sortedTracks);

                                        }
                                        case ARTISTNAME_DESC -> {
                                            System.out.println("🔎 가수이름 가나다순으로 조회하기");
                                            List<TrackDTO> sortedTracks = sh.searchTop50();
                                            sortedTracks.sort(new AscArtistName());
                                            pl.displayTopTracks(sortedTracks);

                                        }

                                        case ARTISTNAME_ASC -> {
                                            System.out.println("🔎 가수이름 역순으로 조회하기");
                                            List<TrackDTO> sortedTracks = sh.searchTop50();
                                            sortedTracks.sort(new DescArtistName());
                                            pl.displayTopTracks(sortedTracks);
                                        }
                                        case NAME_DESC -> {
                                            System.out.println("🔎 곡명 가나다순으로 조회하기");
                                            List<TrackDTO> sortedTracks = sh.searchTop50();
                                            sortedTracks.sort(new AscTrackName());
                                            pl.displayTopTracks(sortedTracks);
                                        }
                                        case NAME_ASC -> {
                                            System.out.println("🔎 곡명 역순으로 조회하기");
                                            List<TrackDTO> sortedTracks = sh.searchTop50();
                                            sortedTracks.sort(new DescTrackName());
                                            pl.displayTopTracks(sortedTracks);
                                        }

                                        case EXIT -> System.out.println("메인메뉴로 돌아갑니다");
                                    }
                                }
                            }
                        }
                        case TOTAL_SEARCH -> {
                            System.out.print("검색어를 입력해주세요 : ");
                            String search = InputUtils.nextLine();

                            result = sh.searchTracks(search);
                            result.sort(new DescArtistName());
                            pl.printTrack(result);

                            System.out.print("번호를 선택해주세요 : ");

                            String choice = InputUtils.nextLine();
                            if ("q".equalsIgnoreCase(choice)) {
                                return;
                            }

                            try {
                                int index = Integer.parseInt(choice) - 1;
                                pl.printAlbum(sh.searchAlbum(result.get(index).getCollectionId()));
                                AudioPlayer.play(result.get(index).getPreviewUrl());
                                waitForUserToStopMusic();
                                cartController.put(result.get(index).getCollectionId());
                            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                                System.out.println(choice + " 명령어는 찾을 수 없습니다");
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
                                cartController.buy(myAlbum);
                                money -= totalPrice;
                            }
                        }
                        case EXIT -> {
                            System.out.println("메인메뉴로 돌아갑니다.");
                        }
                    }
                }
                case LOGOUT -> isLogin = false;
                case EXIT -> {
                    System.out.println("종료합니다.");
                    System.exit(0);
                }
            }
        }
    }

    private boolean tryLogin() {
        String userId = InputUtils.nextLine("아이디를 입력해주세요");
        String userPassword = InputUtils.nextLine("비밀번호를 입력해주세요");

        if (!userInMemoryRepository.userExists(userId)) {
            System.out.println("존재하지 않는 아아디입니다.");
        } else if (!userInMemoryRepository.login(userId, userPassword)) {
            System.out.println("잘못된 비밀번호입니다.");
        } else {
            System.out.printf("%s님, 환영합니다.\n", userId);
            CartRepository cartRepository = carts.getCart(userId);
            CartService cartService = new CartService(cartRepository, sh);
            cartController = new CartController(cartService);
            myAlbum = myAlbums.getMyAlbum(userId);
            return true;
        }
        return false;
    }

    private void signUp() {
        String userId = InputUtils.nextLine("아이디를 입력해주세요");
        String userPassword = InputUtils.nextLine("비밀번호를 입력해주세요");
        if (userInMemoryRepository.userExists(userId)) {
            System.out.println("이미 존재하는 아이디입니다.");
            signUp();
        }
        User user = new User(userId, userPassword);
        userInMemoryRepository.save(user);
        carts.addCart(userId, new CartInMemoryRepository());
        myAlbums.addMyAlbum(userId, new MyAlbum());
        System.out.println("회원가입을 완료했습니다.");
    }

    private void waitForUserToStopMusic() {
        System.out.print("q를 눌러 음악을 중지할수 있습니다 : ");
        String input = InputUtils.nextLine();
        if ("q".equalsIgnoreCase(input)) {
            AudioPlayer.pause(); // 일시정지합니다.
        } else {
            // 새로운 미디어를 재생합니다.
            AudioPlayer.play(input);
            waitForUserToStopMusic(); // 재귀적으로 다음 입력을 대기합니다.
        }
    }
}


