package com.company;

import entities.Customer;
import entities.Driver;
import entities.Location;

public class Main {

    public static void main(String[] args) {
        Location from_location = new Location(55.45f, 37.36f);
        Location to_location = new Location(13.45f, 100.3f);
        Customer customer = new Customer("John", "Grey", "+380508446564");
        customer.makeOrder(from_location, to_location);
        Driver driver = new Driver("Bob", "Bob", "380508005421");
        driver.getOrder();
        driver.processOrder();
    }
}
