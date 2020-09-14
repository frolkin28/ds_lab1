package entities;

import java.util.UUID;
import services.Dispatcher;

public final class Customer {
    private final String uuid;
    private final String first_name;
    private final String last_name;
    private final String phone;

    public Customer(String first_name, String last_name, String phone) {
        this.uuid = UUID.randomUUID().toString();
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }

    public void makeOrder(Location from, Location destination) {
        Dispatcher dispatcher = new Dispatcher();
        System.out.printf("Customer %s, %s made an order\n", this.first_name, this.last_name);
        dispatcher.createOrder(from, destination);
    }
}
