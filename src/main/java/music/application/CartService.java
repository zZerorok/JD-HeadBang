package music.application;

import music.domain.CartItem;
import music.domain.CartRepository;
import music.domain.MyAlbum;
import music.domain.Search;
import music.domain.dto.AlbumDTO;

import java.util.List;

public class CartService {
    private final CartRepository cartRepository;
    private final Search search;

    public CartService(CartRepository cartRepository, Search search) {
        this.cartRepository = cartRepository;
        this.search = search;
    }

    public void put(List<String> albumIds) {
        List<AlbumDTO> albums = search.find(albumIds);
        if (albumIds.size() != albums.size()) {
            throw new IllegalArgumentException("요청 앨범 목록과 검색 결과가 일치하지 않습니다.");
        }
        if (albums.isEmpty()) {
            throw new IllegalArgumentException("앨범 목록을 찾을 수 없습니다.");
        }

        List<CartItem> items = albums.stream()
                .map(CartItem::new)
                .toList();
        cartRepository.save(items);
    }

    public void cancel(List<Integer> cartItemIds) {
        cartRepository.delete(cartItemIds);
    }

    public List<CartItem> findAll() {
        return cartRepository.findAll();
    }

    public void update(int inputCartItemIds, int quantity) {
        cartRepository.update(inputCartItemIds, quantity);
    }

    public void buy(MyAlbum myAlbum) {
        // Search 사용
        cartRepository.buy(myAlbum, search);
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        List<CartItem> cartItems = cartRepository.findAll();
        for (CartItem item : cartItems) {
            totalPrice += item.getAlbum().getCollectionPriceKRW() * item.getQuantity();
        }
        return totalPrice;
    }
}
