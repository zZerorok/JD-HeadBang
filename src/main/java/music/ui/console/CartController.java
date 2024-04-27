package music.ui.console;

import music.application.CartService;
import music.domain.CartItem;
import music.ui.console.utils.InputUtils;

import java.util.Arrays;
import java.util.List;

public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    public void showCart() {
        List<CartItem> cartItems = cartService.findAll();
        System.out.println("장바구니 ID | 앨범 이름 | 앨범 가격 | 수량");
        for (CartItem cartItem : cartItems) {
            System.out.println(cartItem.getId() + " | " + cartItem.getAlbum().getCollectionName() + " | " + cartItem.getAlbum().getCollectionPrice() + " | " + cartItem.getQuantity());
        }
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

    public void buy() {
        // TODO: 창연님 기능 구현
    }
}
