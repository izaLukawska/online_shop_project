package com.youcandev.store.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrderTest {

    @Test
    void calculateTotalPriceIsCorrect() {
        //given

        var product = Product.builder().price(BigDecimal.valueOf(250)).build();
        var product1 = Product.builder().price(BigDecimal.valueOf(100)).build();
        var order = new Order();
        order.setProducts(List.of(product, product1));
        BigDecimal expectedResult = BigDecimal.valueOf(350);

        //when
        BigDecimal result = order.calculateTotalPrice();

        //then
        assertEquals(expectedResult, result);
    }
}