package music.infrastructure;

import music.domain.dto.User;

import java.util.HashMap;
import java.util.Map;

public class UserInMemoryRepository {
    private final Map<String, User> userMap = new HashMap<>();

    public void save(User user) {
        userMap.put(user.getId(), user);
    }

    public User findUserById(String id) {
        return userMap.get(id);
    }

    public boolean userExists(String id) {
        return userMap.containsKey(id);
    }

    public boolean login(String id, String password) {
        User user = userMap.get(id);
        return user != null && user.getPassword().equals(password);
    }
}
