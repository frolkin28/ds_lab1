package entities;

import java.util.UUID;
import services.Dispatcher;

public final class Driver {
    private final String uuid;
    private final String first_name;
    private final String last_name;
    private final String phone;
    private Order order_to_process;

    public Driver(String first_name, String last_name, String phone) {
        this.uuid = UUID.randomUUID().toString();
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone = phone;
    }

    public String getUuid() {
        return uuid;
    }

    public void getOrder() {
        Dispatcher dispatcher = new Dispatcher();
        Order order = dispatcher.getOrder(this);
        System.out.printf("Driver %s got order %s\n", this.uuid, order.getUuid());
        this.order_to_process = order;
    }

    public void processOrder() {
        System.out.printf("Order %s has been processed by driver %s\n", this.order_to_process.getUuid(), this.getUuid());
        Dispatcher dispatcher = new Dispatcher();
        dispatcher.completeOrder(this.order_to_process);
    }
}
