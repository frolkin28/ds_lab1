package services;

import storages.DriverStorage;
import storages.UserStorage;

public class LoginService {
    private final UserStorage user_storage = new UserStorage();
    private final DriverStorage driver_storage = new DriverStorage();

    public String loginUser(String email, String password) {
        String key = user_storage.getApi_key(email, password);
        if (key == null) {
            System.out.println("Invalid email or password");
        }
        else {
            System.out.println("User was successfully logged in");
        }
        return key;
    }

    public String loginDriver(String number, String password) {
        String key = driver_storage.getApi_key(number, password);
        if (key == null) {
            System.out.println("Invalid car number or password");
        }
        else {
            System.out.println("Driver was successfully logged in");
        }
        return key;
    }
}
