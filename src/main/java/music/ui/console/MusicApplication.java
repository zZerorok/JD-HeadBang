package music.ui.console;

import Service.AudioPlayer;
import javafx.application.Application;
import javafx.stage.Stage;
import music.application.CartService;

import static javafx.application.Application.launch;

public class MusicApplication{

    public static void main(String[] args) {
        //Application.launch(Service.AudioPlayer.class,"https://audio-ssl.itunes.apple.com/itunes-assets/AudioPreview116/v4/01/a4/8c/01a48c35-a92a-5fde-818c-eac44bc08825/mzaf_9694690388777143301.plus.aac.p.m4a");
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
