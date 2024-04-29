package music.ui.console;

public enum PurchaseCommand {
    PURCHASE("1", "구매"),
    CHANGE_AMOUNT("2", "수량변경"),
    PUT("3", "장바구니 담기"),
    CANCEL("4", "장바구니 목록 제거"),
    EXIT("0", "취소하기");

    private final String code;
    private final String title;

    PurchaseCommand(String code, String title) {
        this.code = code;
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static PurchaseCommand from(String code) {
        for (PurchaseCommand purchaseCommand : values()) {
            if (purchaseCommand.code.equals(code)) {
                return purchaseCommand;
            }
        }
        throw new IllegalArgumentException(code + " 명령어는 찾을 수 없습니다");
    }
}
