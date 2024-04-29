package music.ui.console;

public enum SearchCommand {
    SHOW_ALBUM("1", "새로들어온 노래"),
    TOTAL_SEARCH("2", "검색"),
    EXIT("0", "종료하기");

    private final String code;
    private final String title;

    SearchCommand(String code, String title) {
        this.code = code;
        this.title = title;
    }
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static SearchCommand from(String code) {
        for (SearchCommand search_Command : values()) {
            if (search_Command.code.equals(code)) {
                return search_Command;
            }
        }
        throw new IllegalArgumentException(code + " 명령어는 찾을 수 없습니다");
    }
}
