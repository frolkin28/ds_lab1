package com.company;

import entities.Driver;
import entities.Location;
import entities.Order;
import services.Dispatcher;
import services.LoginService;
import services.PermissionService;
import services.RegistrationService;
import entities.User;

public class Main {

    public static void main(String[] args) {
        System.out.println("Lets create and register driver and user");
        User user = new User("First", "Last", "frolkin2801@gmail.com", "test");
        Driver driver = new Driver("First", "Last", "BB4058AC", "test");

        RegistrationService rs = new RegistrationService();

        rs.registerUser(user);
        rs.registerDriver(driver);

        System.out.println("Then let them enter their accounts");
        LoginService ls = new LoginService();
        // keys are unique identifiers (could be replaced with jwt in rest)
        String driver_key = ls.loginDriver(driver.getCar_number(), driver.getPassword());
        String user_key = ls.loginUser(user.getEmail(), user.getPassword());

        Dispatcher dp = new Dispatcher();
        PermissionService ps = new PermissionService();

        System.out.println("Then user make an order, driver process it");
        if (ps.is_users_method_allowed(user_key)) {
            Location from_location = new Location(55.45f, 37.36f);
            Location to_location = new Location(13.45f, 100.3f);

            dp.createOrder(from_location, to_location);

        }

        else {
            System.out.println("You can't make order without login");
        }

        if (ps.is_drivers_method_allowed(driver_key)) {
            Order order = dp.getOrder(driver);
            System.out.println("Driver got order and stated to process");
            dp.completeOrder(order);
            System.out.println("Customer is happy");
        }

        else {
            System.out.println("You can't get order without login");
        }
    }
}
