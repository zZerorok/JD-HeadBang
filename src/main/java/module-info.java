module AudioPlayerModule {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    // 실제 패키지 이름으로 수정
    opens music.service to javafx.fxml;
    exports music.service;
}