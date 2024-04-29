package music.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyAlbum {
    private final Map<Integer, CartItem> albumMap = new HashMap<>();

    public void save(Map<Integer, CartItem> cartItemMap) {
        albumMap.putAll(cartItemMap);
    }

    public void showMyAlbum() {
        System.out.println("소유한 앨범 ID | 앨범 이름 | 앨범 가격 | 수량");
        ArrayList<CartItem> myAlbumList = new ArrayList<>(albumMap.values());
        for (CartItem cartItem : myAlbumList) {
            System.out.println(cartItem.getId() + " | " + cartItem.getAlbum().getCollectionName() + " | " + cartItem.getAlbum().getCollectionPriceKRW() + " | " + cartItem.getQuantity());
        }
    }
}
