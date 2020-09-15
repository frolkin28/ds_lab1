package com.company;

import entities.Driver;
import services.RegistrationService;
import entities.User;

public class Main {

    public static void main(String[] args) {
        User user = new User("First", "Last", "frolkin2801@gmail.com");
        Driver driver = new Driver("First", "Last", "BB4058AC");
        RegistrationService rs = new RegistrationService();
        rs.registerUser(user);
        rs.registerDriver(driver);
    }
}
