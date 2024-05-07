package music.infrastructure;

import music.domain.CartRepository;

import java.util.HashMap;
import java.util.Map;

public class Carts {
    private final Map<String, CartRepository> cartMap = new HashMap<>();

    public void addCart(String id, CartRepository cartRepository) {
        cartMap.put(id, cartRepository);
    }

    public CartRepository getCart(String id) {
        return cartMap.get(id);
    }
}
