package com.youcandev.store.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data

public class Order {

    private Long id;
    private Customer customer;
    private List<Product> products;
    private OrderStatus status;

    public BigDecimal calculateTotalPrice(){
        return products.stream().map(Product::getPrice)
                .reduce((currentAmount, sum) -> sum.add(currentAmount)).orElse(BigDecimal.ZERO);

    }
}
