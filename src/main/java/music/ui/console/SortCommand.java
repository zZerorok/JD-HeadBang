package music.ui.console;

public enum SortCommand {
    RELEASEDATE_DESC("1", "발매일이 오래된순부터 조회하기"),
    RELEASEDATE_ASC("2", "발매일이 최신순부터 조회하기"),
    ARTISTNAME_DESC("3", "가수이름 가나다순으로 조회하기"),
    ARTISTNAME_ASC("4", "가수이름 역순으로 조회하기"),
    NAME_DESC("5", "곡명 가나다순으로 조회하기"),
    NAME_ASC("6", "곡명 역순으로 조회하기"),
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
        throw new IllegalArgumentException("해당 " + code + "번 명령어는 찾을 수 없습니다");
    }
}
