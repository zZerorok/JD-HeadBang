package music.ui.console;

public enum Command {
    SEARCHALBUM("1", "검색"),
    CART("2", "장바구니"),
    EXIT("0", "종료하기");


    private final String code;
    private final String title;

    Command(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static Command from(String code) {
        for (Command command : values()) {
            if (command.code.equals(code)) {
                return command;
            }
        }
        throw new IllegalArgumentException(code + " 명령어는 찾을 수 없습니다");
    }
}

