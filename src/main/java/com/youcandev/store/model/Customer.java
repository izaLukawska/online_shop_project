package com.youcandev.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.List;

@Data
@AllArgsConstructor

public class Customer {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private List<Order> orders;

    public void addOrder(Order order){
        orders.add(order);
    }
}
