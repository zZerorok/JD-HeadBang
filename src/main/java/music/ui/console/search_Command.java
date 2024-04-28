package music.ui.console;

public enum search_Command {
    showAlbum("1", "보유중인 엘범"),
    totalSearch("2", "통합검색"),
    exit("0", "종료하기");

    private final String code;
    private final String title;

    search_Command(String code, String title) {
        this.code = code;
        this.title = title;
    }
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static search_Command from(String code) {
        for (search_Command search_Command : values()) {
            if (search_Command.code.equals(code)) {
                return search_Command;
            }
        }
        throw new IllegalArgumentException(code + " 명령어는 찾을 수 없습니다");
    }
}
