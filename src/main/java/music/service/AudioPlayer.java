package music.service;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import java.util.Scanner;
public class AudioPlayer extends Application {
    private MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) {
        // 전달된 매개변수에서 URL 가져오기
        String[] parameters = getParameters().getRaw().toArray(new String[0]);
        if (parameters.length == 0) {
            throw new IllegalArgumentException("No URL provided");
        }

        String fileUrl = parameters[0]; // 첫 번째 매개변수
        configureMediaPlayer(fileUrl); // MediaPlayer 설정\

        monitorConsoleForExit();
    }
    private void monitorConsoleForExit() {
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String input = scanner.nextLine().trim(); // 콘솔 입력 받기
                if ("q".equalsIgnoreCase(input)) { // 'q' 입력 시
                    Platform.runLater(() -> {
                        if (mediaPlayer != null) {
                            mediaPlayer.stop(); // 음악 중지
                        }
                    });
                }
            }
        }).start(); // 스레드 시작
    }

    /**
     * 주어진 URL로 MediaPlayer를 설정하는 메서드
     */
    private void configureMediaPlayer(String fileUrl) {
        Media media = new Media(fileUrl); // Media 객체 생성
        mediaPlayer = new MediaPlayer(media); // MediaPlayer 생성
        mediaPlayer.setAutoPlay(true); // 자동 재생
        mediaPlayer.setOnEndOfMedia(() -> {
            Platform.exit(); // JavaFX 애플리케이션 종료
        });
    }
}
