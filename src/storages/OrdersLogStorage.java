package storages;

import entities.Order;

import java.util.ArrayList;

public class OrdersLogStorage {
    private final ArrayList<Order> storage = new ArrayList<>();

    public void add(Order order) {
        storage.add(order);
    }

    public void update(Order order) {
        for (int i = 0; i < storage.size(); i++) {
            Order item = storage.get(i);
            if (order.getUuid().equals(item.getUuid()))
                storage.set(i, order);
        }
    }
}
