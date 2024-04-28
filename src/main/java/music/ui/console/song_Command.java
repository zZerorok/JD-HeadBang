package music.ui.console;

public enum song_Command {
    sort("1", "정렬"),
    showAlbum("2", "노래를 통해 엘범 도출"),
    exit("0", "종료하기");

    private final String code;
    private final String title;

    song_Command(String code, String title) {
        this.code = code;
        this.title = title;
    }
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static song_Command from(String code) {
        for (song_Command song_Command : values()) {
            if (song_Command.code.equals(code)) {
                return song_Command;
            }
        }
        throw new IllegalArgumentException(code + " 명령어는 찾을 수 없습니다");
    }
}
