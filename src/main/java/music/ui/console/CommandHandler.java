package music.ui.console;

import music.service.Database;
import music.ui.console.utils.InputUtils;
import view.PrintList;

public class CommandHandler {
    private final CartController cartController;
    PrintList pl = new PrintList();
    Database db = new Database();

    public CommandHandler(CartController cartController) {
        this.cartController = cartController;
    }

    public void run() {
        boolean isRunning = true;
        // 메인메뉴 커맨드
        for (Command command : Command.values()) {
            System.out.println(command.getCode() + ". " + command.getTitle());
        }

        String inputCommand = InputUtils.nextLine();
        Command command = Command.from(inputCommand);

        // 검색메뉴 커맨드
        for (search_Command search_Command : search_Command.values()) {
            System.out.println(search_Command.getCode() + ". " + search_Command.getTitle());
        }

        //장바구니 커맨드
        for (purchase_Command purchase_Command : purchase_Command.values()) {
            System.out.println(purchase_Command.getCode() + ". " + purchase_Command.getTitle());
        }


        switch (command) {
            case SHOW_ALBUM -> {
                System.out.println("뱅뱅뮤직스토어에 온걸 환영합니다");
                System.out.println("이번에 들어온 노래 : ");
                pl.printAllList(db.getAlbumList());
            }
            case SEARCH_ALBUM -> {
                String inputSearchCommand = InputUtils.nextLine();
                search_Command command2 = search_Command.from(inputSearchCommand);

                switch (command2) {
                    case SHOW_ALBUM -> {
                        System.out.println("가지고있는 엘범 목록입니다.");
                    }
                    case SEARCH_BYSINGER -> {
                        System.out.println("가수로 검색합니다");
                    }
                    case SEARCH_TITLE -> {
                        System.out.println("제목으로 검색합니다");
                    }
                    case EXIT -> {
                        System.out.println("메인메뉴로 돌아갑니다");
                    }
                }
            }
            case BUY_ALBUM -> {
                String inputpurchaseCommand = InputUtils.nextLine();
                purchase_Command command3 = purchase_Command.from(inputpurchaseCommand);
                switch (command3){
                    case PURCHASE -> {
                        cartController.buy();
                    }
                    case CHANGE_AMOUNT -> {
                        //구매수량 변경
                        System.out.println("수량을 변경합니다");
                    }
                    case EXIT -> {
                        System.out.println("메인메뉴로 돌아갑니다");
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
