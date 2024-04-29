package music.ui.console;

public enum sort_Command {
    sortByReleaseDateASC("1", "발매일 오름차순"),
    sortByReleaseDateDESC("2", "발매일 내림차순"),
    sortByArtistNameASC("3", "가수이름 오름차순"),
    sortByArtistNameDESC("4", "가수이름 내림차순"),
    exit("0", "종료하기");

    private final String code;
    private final String title;

    sort_Command(String code, String title) {
        this.code = code;
        this.title = title;
    }
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static sort_Command from(String code) {
        for (sort_Command sort_Command : values()) {
            if (sort_Command.code.equals(code)) {
                return sort_Command;
            }
        }
        throw new IllegalArgumentException(code + " 명령어는 찾을 수 없습니다");
    }
}
