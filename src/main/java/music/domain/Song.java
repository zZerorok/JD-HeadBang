package music.domain;

import java.time.LocalDateTime;

public class Song {
    private Long id;
    private String name;
    private String creator;
    private LocalDateTime createdAt;

    public Song(Long id, String name, String creator, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.createdAt = createdAt;
    }
}
