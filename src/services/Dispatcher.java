package services;

import entities.Driver;
import entities.Location;
import entities.Order;
import entities.OrderStatus;
import storages.OrdersLogStorage;

public final class Dispatcher {
    private final OrdersQueue queue_service = new OrdersQueue();
    private final CostService cost_service = new CostService();
    private final OrdersLogStorage orders_log_storage = new OrdersLogStorage();

    public Order getOrder(Driver driver) {
        Order order = queue_service.pop();
        order.setDriver(driver);
        System.out.printf("Order %s was sent to a driver\n", order.getUuid());
        order.setStatus(OrderStatus.PROCESSING);
        orders_log_storage.update(order);
        return order;
    }

    public void completeOrder(Order order) {
        System.out.printf("Order %s is complete\n", order.getUuid());
        order.setStatus(OrderStatus.COMPLETE);
        orders_log_storage.update(order);
    }

    public void createOrder(Location from, Location destination) {
        double cost = cost_service.calculate(from, destination);
        Order order = new Order(from, destination, cost);
        System.out.printf("Order %s created, it will cost %f\n", order.getUuid(), order.getCost());
        queue_service.push(order);
        orders_log_storage.add(order);
    }
}
