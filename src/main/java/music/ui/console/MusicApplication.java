package music.ui.console;

import music.application.CartService;

public class MusicApplication {

    public static void main(String[] args) {
        CartService cartService = new CartService();
        CartController cartController = new CartController(cartService);

        CommandHandler commandHandler = new CommandHandler(cartController);

        while (true) {
            try {
                commandHandler.run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
