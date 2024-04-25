package music.ui.console;

import music.ui.console.utils.InputUtils;

public class CommandHandler {
    private final CartController cartController;

    public CommandHandler(CartController cartController) {
        this.cartController = cartController;
    }

    public void run() {
        for (Command command : Command.values()) {
            System.out.println(command.getCode() + ". " + command.getTitle());
        }

        String inputCommand = InputUtils.nextLine();
        Command command = Command.from(inputCommand);

        switch (command) {
            case SHOW_ALBUM -> {
                // TODO: 컨트롤러 호출
            }
            case BUY_ALBUM -> {
                cartController.buy();
            }
            case EXIT -> {
                System.out.println("종료합니다.");
                System.exit(0);
            }
        }
    }


}
