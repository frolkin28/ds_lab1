package services;

import entities.Driver;
import entities.User;
import exceptions.InvalidCarNumber;
import exceptions.InvalidEmail;
import storages.DriverStorage;
import storages.UserStorage;

public class RegistrationService {
    private ValidationService validation_service = new ValidationService();
    private UserStorage user_storage = new UserStorage();
    private DriverStorage driver_storage = new DriverStorage();

    public void registerUser(User user) {
        try {
            validation_service.validateEmail(user.getEmail());
            user_storage.add(user);
            System.out.printf("User %s %s has been registered\n", user.getFirst_name(), user.getLast_name());
        }
        catch (InvalidEmail e) {
            System.out.println(e.getMessage());
            System.out.println("Try to register again");
        }
    }

    public void registerDriver(Driver driver) {
        try {
            validation_service.validateCarNumber(driver.getCar_number());
            driver_storage.add(driver);
            System.out.printf("Driver %s %s has been registered\n", driver.getFirst_name(), driver.getLast_name());
        }
        catch (InvalidCarNumber e) {
            System.out.println(e.getMessage());
            System.out.println("Try to register again");
        }
    }

}
