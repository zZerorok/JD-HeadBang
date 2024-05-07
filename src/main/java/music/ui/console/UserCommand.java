package music.ui.console;

public enum UserCommand {
    SIGN_UP("1","회원가입"),
    LOGIN("2", "로그인");

    private final String code;
    private final String title;

    UserCommand(String code, String title) {
        this.code = code;
        this.title = title;
    }
    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static UserCommand from(String code) {
        for (UserCommand command : values()) {
            if (command.code.equals(code)) {
                return command;
            }
        }
        throw new IllegalArgumentException("해당 " + code + "번 명령어는 찾을 수 없습니다");
    }
}
