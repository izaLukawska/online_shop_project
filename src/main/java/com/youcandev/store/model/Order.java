package com.youcandev.store.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private Long id;
    private Customer customer;
    private List<Product> products;
    private OrderStatus status;

    public Order(Long id, Customer customer, List<Product> products, OrderStatus status) {
        this.id = id;
        this.customer = customer;
        this.products = products;
        this.status = OrderStatus.PENDING;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal calculateTotalPrice(){
        return products.stream().map(Product::getPrice)
                .reduce((currentAmount, sum) -> sum.add(currentAmount)).orElse(BigDecimal.ZERO);

    }
}
