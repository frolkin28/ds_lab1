package entities;

import java.util.UUID;
import services.CostService;

public final class Order {
    private final String uuid;
    private Driver driver;
    private final Location from;
    private final Location destination;
    private final double cost;
    private Status status;

    public Order(Location from, Location destination) {
        this.uuid = UUID.randomUUID().toString();
        this.driver = null;
        this.from = from;
        this.destination = destination;
        this.cost = CostService.calculate(this.from, this.destination);
        this.status = Status.AVAILABLE;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getUuid() {
        return uuid;
    }

    public double getCost() {
        return cost;
    }
}
