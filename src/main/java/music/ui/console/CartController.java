package music.ui.console;

import music.application.CartService;
import music.domain.MyAlbum;
import music.ui.console.utils.InputUtils;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CartController {
    private final CartService cartService;
    private final PrintList pl = new PrintList();

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    public void showCart() {
        System.out.println("장바구니 ID | 앨범 이름 | 앨범 가격 | 수량");
        String cartItems = cartService.findAll()
                .stream()
                .map(it ->
                        MessageFormat.format("  {0}  |  {1}  |  {2}  |  {3}  ",
                                it.getId(),
                                it.getAlbum().getCollectionName(),
                                it.getAlbum().getCollectionPriceKRW(),
                                it.getQuantity()
                        )
                ).collect(Collectors.joining(System.lineSeparator()));
        System.out.println(cartItems);
    }

    public void put() {
        String inputAlbumIds = InputUtils.nextLine("앨범 아이디를 입력해 주세요. (구분자: ,)");
        List<String> albumIds = Arrays.stream(inputAlbumIds.split(","))
                .map(String::trim)
                .toList();
        cartService.put(albumIds);
        System.out.println("앨범 목록을 장바구니에 담았습니다.");
    }

    public void cancel() {
        String inputCartItemIds = InputUtils.nextLine("장바구니 번호를 입력해 주세요. (구분자: ,)");
        List<Integer> cartItemIds = Arrays.stream(inputCartItemIds.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        cartService.cancel(cartItemIds);
        System.out.println("선택한 장바구니 목록을 비웠습니다.");
    }

    public void buy(MyAlbum myAlbum) {
        cartService.buy(myAlbum);
    }

    public void update() {
        int inputCartItemIds = Integer.parseInt(InputUtils.nextLine("장바구니 번호를 입력해 주세요."));
        int quantity = Integer.parseInt(InputUtils.nextLine("변경하려는 개수를 입력해 주세요."));
        cartService.update(inputCartItemIds, quantity);
        System.out.println("선택한 장바구니 개수를 변경했습니다.");
    }

    public int getTotalPrice() {
        return cartService.getTotalPrice();
    }
}
