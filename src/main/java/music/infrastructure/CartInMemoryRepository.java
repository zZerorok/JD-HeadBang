package music.infrastructure;

import music.domain.CartItem;
import music.domain.CartRepository;
import music.domain.MyAlbum;
import music.domain.dto.AlbumDTO;
import music.service.Database;

import java.util.*;

public class CartInMemoryRepository implements CartRepository {
    private int id = 0;

    private final Map<Integer, CartItem> cartItemMap = new HashMap<>();

    @Override
    public void save(List<CartItem> item) {
        for (CartItem cartItem : item) {
            save(cartItem);
        }
    }

    @Override
    public void save(CartItem item) {
        int newId = ++id;
        item.setId(newId);
        cartItemMap.put(newId, item);
    }

    @Override
    public void delete(List<Integer> id) {
        for (Integer itemId : id) {
            delete(itemId);
        }
    }

    @Override
    public void delete(Integer id) {
        if (!cartItemMap.containsKey(id)) {
            throw new IllegalArgumentException(id + "번 장바구니 아이디를 찾을 수 없습니다.");
        }
        cartItemMap.remove(id);
    }

    @Override
    public List<CartItem> findAllById(List<Integer> ids) {
        return ids.stream()
                .map(cartItemMap::get)
                .toList();
    }

    @Override
    public List<CartItem> findAll() {
        return new ArrayList<>(cartItemMap.values());
    }


    @Override
    public void update(int inputCartItemIds, int quantity) {
        CartItem cartItem = cartItemMap.get(inputCartItemIds);
        cartItem.setQuantity(quantity);
        cartItemMap.put(inputCartItemIds, cartItem);
    }

    @Override
    public void buy(MyAlbum myAlbum, Database db) {
        myAlbum.save(cartItemMap);
        cartItemMap.values().forEach(cartItem -> {
            String collectionId = cartItem.getAlbum().getCollectionId();
            AlbumDTO foundAlbumDTO = db.findAlbumById(collectionId);
            int quantity = cartItem.getQuantity();
            foundAlbumDTO.decrementQuantity(quantity);
        });
        id = 0;
        cartItemMap.clear();
    }
}