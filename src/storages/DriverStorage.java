package storages;

import entities.Driver;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class DriverStorage {
    private final static HashMap<String, Driver> storage = new HashMap<>();

    public void add(Driver driver) {
        String uuid = UUID.randomUUID().toString();
        storage.put(uuid, driver);
    }

    public void remove(String api_key) {
        storage.remove(api_key);
    }

    public boolean contains(String api_key) {
        return storage.containsKey(api_key);
    }

    public String getApi_key(String number, String password) {
        for (Map.Entry<String, Driver> set : storage.entrySet()) {
            String key = set.getKey();
            String registered_driver_number = set.getValue().getCar_number();
            String registered_driver_password = set.getValue().getPassword();

            boolean logins_equal = registered_driver_number.equals(number);
            boolean password_equal = registered_driver_password.equals(password);

            if (logins_equal && password_equal) {
                return key;
            }
        }
        return null;
    }
}
