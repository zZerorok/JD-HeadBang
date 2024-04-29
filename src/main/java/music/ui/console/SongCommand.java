package music.ui.console;

public enum SongCommand {
    SORT("1", "정렬"),
    EXIT("0", "종료하기");

    private final String code;
    private final String title;

    SongCommand(String code, String title) {
        this.code = code;
        this.title = title;
    }
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static SongCommand from(String code) {
        for (SongCommand song_Command : values()) {
            if (song_Command.code.equals(code)) {
                return song_Command;
            }
        }
        throw new IllegalArgumentException(code + " 명령어는 찾을 수 없습니다");
    }
}
