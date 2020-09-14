package services;

import entities.Driver;
import entities.Location;
import entities.Order;
import entities.Status;

public final class Dispatcher {
    private final OrdersQueue queue_service;

    public Dispatcher() {
        this.queue_service = new OrdersQueue();
    }

    public Order getOrder(Driver driver) {
        Order order = this.queue_service.pop();
        order.setDriver(driver);
        System.out.printf("Order %s was sent to a driver %s\n", order.getUuid(), driver.getUuid());
        order.setStatus(Status.PROCESSING);
        return order;
    }

    public void completeOrder(Order order) {
        System.out.printf("Order %s is complete\n", order.getUuid());
        order.setStatus(Status.COMPLETE);
    }

    public void createOrder(Location from, Location destination) {
        Order order = new Order(from, destination);
        System.out.printf("Order %s created, it will cost %f\n", order.getUuid(), order.getCost());
        this.queue_service.push(order);
    }
}
