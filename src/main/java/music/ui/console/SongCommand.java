package music.ui.console;

public enum SongCommand {
    SORT("1", "🔎 여러 정렬 기준으로 조회할 수 있습니다. (가수/곡명/발매일)"),
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
        throw new IllegalArgumentException("해당 " + code + "번 명령어는 찾을 수 없습니다");
    }
}
