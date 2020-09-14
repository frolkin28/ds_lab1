package services;

import java.util.ArrayDeque;
import entities.Order;

public final class OrdersQueue {
    private final static ArrayDeque<Order> orders_queue = new ArrayDeque<Order>();

    public void push(Order order) {
        orders_queue.addLast(order);
    }

    public Order pop() {
        return orders_queue.getFirst();
    }
}
