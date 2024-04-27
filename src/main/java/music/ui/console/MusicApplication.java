package music.ui.console;


public class MusicApplication {

    public static void main(String[] args) {
        CommandHandler commandHandler = new CommandHandler();

        while (true) {
            System.out.println("============================");
            try {
                commandHandler.run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }

    }
}
