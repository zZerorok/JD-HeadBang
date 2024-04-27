package music.ui.console;

public enum purchase_Command {
    PURCHASE("1", "구매"),
    CHANGE_AMOUNT("2", "수량변경"),
    PUT("3", "장바구니 담기"),
    CANCEL("4", "장바구니 목록 제거"),
    EXIT("0", "취소하기");

    private final String code;
    private final String title;

    purchase_Command(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static purchase_Command from(String code) {
        for (purchase_Command purchase_Command : values()) {
            if (purchase_Command.code.equals(code)) {
                return purchase_Command;
            }
        }
        throw new IllegalArgumentException(code + " 명령어는 찾을 수 없습니다");
    }
}
