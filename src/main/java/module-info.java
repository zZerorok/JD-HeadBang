module AudioPlayerModule {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.google.gson;
    requires java.net.http;
    opens music.domain.dto to com.google.gson;

    // 실제 패키지 이름으로 수정
    opens music.service to javafx.fxml;
    exports music.service;
    exports music.domain;
    opens music.domain to javafx.fxml;
    opens music.domain.dto;
}
