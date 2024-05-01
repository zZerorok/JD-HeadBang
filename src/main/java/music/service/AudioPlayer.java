package music.service;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.Scanner;

public class AudioPlayer {
    private static MediaPlayer mediaPlayer;
    private static final JFXPanel fxPanel = new JFXPanel();  // Initializes JavaFX environment

    public static void play(String url) {
        Platform.runLater(() -> {
            if (mediaPlayer != null) {
                mediaPlayer.stop(); // 이전 재생을 중지하고
                mediaPlayer.dispose(); // 미디어 플레이어를 해제합니다.
            }
            Media media = new Media(url);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.play();
        });
    }

    public static void pause() {
        Platform.runLater(() -> {
            if (mediaPlayer != null) {
                mediaPlayer.pause();
            }
        });
    }

    public static void resume() {
        Platform.runLater(() -> {
            if (mediaPlayer != null) {
                mediaPlayer.play();
            }
        });
    }
}
