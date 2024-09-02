package com.youcandev.store.model;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private Long id;
    private Customer customer;
    private List<Product> prodcuts;
    private OrderStatus status;

    public Order(Long id, Customer customer, List<Product> prodcuts, OrderStatus status) {
        this.id = id;
        this.customer = customer;
        this.prodcuts = prodcuts;
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

    public List<Product> getProdcuts() {
        return prodcuts;
    }

    public void setProdcuts(List<Product> prodcuts) {
        this.prodcuts = prodcuts;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public BigDecimal calculateTotalPrice(){
        return prodcuts.stream().map(Product::getPrice)
                .reduce((currentAmount, sum) -> sum.add(currentAmount)).orElse(BigDecimal.ZERO);

    }
}
