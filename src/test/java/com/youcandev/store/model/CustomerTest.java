package com.youcandev.store.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(1L, "Iza", "Lukawska", "x@gmail.com" ,new ArrayList<>());
    }

    @Test
    void addOrderIsSuccessful() {
        Order order = mock(Order.class);
        customer.addOrder(order);
        List<Order> orders = customer.getOrders();
        assertThat(orders).hasSize(1).contains(order);
    }
}