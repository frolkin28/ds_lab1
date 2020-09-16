package services;

import storages.DriverStorage;
import storages.UserStorage;

public class PermissionService {
    private final DriverStorage driver_storage = new DriverStorage();
    private final UserStorage user_storage = new UserStorage();

    public boolean is_drivers_method_allowed(String api_key) {
        return driver_storage.contains(api_key);
    }
    
    public boolean is_users_method_allowed(String api_key) {
        return user_storage.contains(api_key);
    }
}
