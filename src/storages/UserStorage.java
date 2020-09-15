package storages;

import entities.User;

import java.util.HashMap;
import java.util.UUID;

public class UserStorage {
    private HashMap<String, User> storage = new HashMap<>();

    public void add(User user) {
        String uuid = UUID.randomUUID().toString();
        storage.put(uuid, user);
    }

    public void remove(String api_key) {
        storage.remove(api_key);
    }

    public boolean contains(String api_key) {
        return storage.containsKey(api_key);
    }
}
