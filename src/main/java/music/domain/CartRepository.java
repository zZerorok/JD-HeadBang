package music.domain;

import java.util.List;

public interface CartRepository {
    void save(CartItem item);
    void save(List<CartItem> item);
    void delete(Integer id);
    void delete(List<Integer> id);
    List<CartItem> findAllById(List<Integer> ids);
    List<CartItem> findAll();
}
