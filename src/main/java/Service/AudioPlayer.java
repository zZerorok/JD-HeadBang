package Service;
import javafx.application.Application;
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
        // 콘솔에서 URL을 입력받기 위해 Scanner 사용
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter M4A file URL: "); // 사용자에게 입력 요청
        String fileUrl = scanner.nextLine(); // 입력된 URL 가져오기

        // Media 객체 생성
        Media media = new Media(fileUrl);
        mediaPlayer = new MediaPlayer(media);

        // 플레이 버튼 생성
        Button playButton = new Button("Play");
        playButton.setOnAction(e -> mediaPlayer.play()); // 버튼 클릭 시 재생

        // 스톱 버튼 생성
        Button stopButton = new Button("Stop");
        stopButton.setOnAction(e -> mediaPlayer.stop()); // 버튼 클릭 시 재생 중지

        // HBox를 사용하여 버튼을 수평으로 배치하고 중앙에 정렬
        HBox buttonBox = new HBox(10, playButton, stopButton); // 10px 간격으로 배치
        StackPane stackPane = new StackPane(buttonBox); // 중앙에 정렬

        Scene scene = new Scene(stackPane, 300, 100); // 장면 크기 설정
        primaryStage.setTitle("M4A Player"); // 창 제목 설정
        primaryStage.setScene(scene); // 장면 설정
        primaryStage.show(); // 창 표시
    }
}
