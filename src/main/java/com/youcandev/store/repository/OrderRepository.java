package com.youcandev.store.repository;

import com.youcandev.store.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderRepository {

    private final Map<Long, Order> orders = new HashMap<>();

    private static OrderRepository instance;

    private OrderRepository() {}

    private static OrderRepository getInstance(){
        return instance == null ? new OrderRepository() : instance;
    }

    public Order createOrder(Order order){
        return orders.put(order.getId(), order);
    }
    public List<Order> getAllOrders(){
        return orders.values().stream().toList();
    }
    public Optional<Order> getOrderById(Long id){
        return Optional.ofNullable(orders.get(id));
    }
    public Optional<Order> deleteOrder(Long id){
        return Optional.ofNullable(orders.remove(id));
    }
}
