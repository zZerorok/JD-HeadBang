package music.ui.console;

import Service.AudioPlayer;
import javafx.application.Application;
import javafx.stage.Stage;
import music.application.CartService;

import static javafx.application.Application.launch;

public class MusicApplication{

    public static void main(String[] args) {
        Application.launch(Service.AudioPlayer.class, args);
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
