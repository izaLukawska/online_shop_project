package com.youcandev.store.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Data
public class Order {

    private Long id;
    private Customer customer;
    private List<Product> products;
    private OrderStatus status = OrderStatus.PENDING;

    public BigDecimal calculateTotalPrice(){
        return products.stream().map(Product::getPrice)
                .reduce((currentAmount, sum) -> sum.add(currentAmount)).orElse(BigDecimal.ZERO);

    }
}
