package storages;

import entities.Driver;

import java.util.HashMap;
import java.util.UUID;

public class DriverStorage {
    private HashMap<String, Driver> storage = new HashMap<>();

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
}
