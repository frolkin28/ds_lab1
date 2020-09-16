package storages;

import entities.Driver;
import entities.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UserStorage {
    private final static HashMap<String, User> storage = new HashMap<>();

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

    public String getApi_key(String email, String password) {
        for (Map.Entry<String, User> set : storage.entrySet()) {
            String key = set.getKey();
            String registered_user_password = set.getValue().getPassword();
            String registered_user_email = set.getValue().getEmail();

            boolean logins_equal = registered_user_email.equals(email);
            boolean password_equal = registered_user_password.equals(password);

            if (logins_equal && password_equal) {
                return key;
            }
        }
        return null;
    }
}
