package music.domain;

import music.domain.dto.AlbumDTO;
import music.service.Database;

import java.util.List;

public interface CartRepository {
    void save(CartItem item);
    void save(List<CartItem> item);
    void delete(Integer id);
    void delete(List<Integer> id);
    void update(int inputCartItemIds, int quantity);
    void buy(MyAlbum myAlbum, Database db);
    List<CartItem> findAllById(List<Integer> ids);
    List<CartItem> findAll();


}
