package entities;

import java.util.UUID;

public final class Order {
    private final String uuid;
    private Driver driver;
    private final Location from;
    private final Location destination;
    private final double cost;
    private OrderStatus status;

    public Order(Location from, Location destination, double cost) {
        this.uuid = UUID.randomUUID().toString();
        this.from = from;
        this.destination = destination;
        this.cost = cost;
        this.status = OrderStatus.AVAILABLE;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public double getCost() {
        return cost;
    }
}
