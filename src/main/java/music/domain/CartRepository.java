package music.domain;

import java.util.List;

public interface CartRepository {
    void save(CartItem item);
    void save(List<CartItem> item);
    void delete(Integer id);
    void delete(List<Integer> id);
    void update(int inputCartItemIds, int quantity);
    void buy(MyAlbum myAlbum, Search search);
    List<CartItem> findAllById(List<Integer> ids);
    List<CartItem> findAll();


}
