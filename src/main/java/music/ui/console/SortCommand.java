package music.ui.console;

public enum SortCommand {
    RELEASEDATE_ASC("1", "발매일 오름차순"),
    RELEASEDATE_DESC("2", "발매일 내림차순"),
    ARTISTNAME_ASC("3", "가수이름 오름차순"),
    ARTISTNAME_DESC("4", "가수이름 내림차순"),
    EXIT("0", "종료하기");

    private final String code;
    private final String title;

    SortCommand(String code, String title) {
        this.code = code;
        this.title = title;
    }
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static SortCommand from(String code) {
        for (SortCommand sort_Command : values()) {
            if (sort_Command.code.equals(code)) {
                return sort_Command;
            }
        }
        throw new IllegalArgumentException(code + " 명령어는 찾을 수 없습니다");
    }
}
