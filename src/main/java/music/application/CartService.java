package music.application;

import music.domain.Cart;

import java.util.List;

public class CartService {
    private static final Cart cart = new Cart();

    public void put(List<Long> albumIds) {
        if (albumIds.isEmpty()) {
            throw new IllegalArgumentException("하나 이상의 앨범을 담을 수 있습니다.");
        }

        cart.put(List.of());
    }

}
