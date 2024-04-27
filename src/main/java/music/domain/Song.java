package music.domain;

import java.time.LocalDateTime;

public class Song {
    private Long id;
    private String title;
    private String singer;
    private String creator;
    private LocalDateTime createdAt;

    public Song(Long id, String title, String singer,  String creator, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.singer = singer;
        this.creator = creator;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "곡 [" +
                "번호 =" + id +
                ", 제목 ='" + title + '\'' +
                ", 가수 ='" + singer + '\'' +
                ", 작곡가 ='" + creator + '\'' +
                ", 발매일 =" + createdAt +
                '}';
    }
}
