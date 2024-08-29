package com.youcandev.store.model;

import java.math.BigDecimal;

public class ProductBuilder {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantityInStock;


    public ProductBuilder setId(Long id) {
        this.id = id;
        return this;
    }

    public ProductBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ProductBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductBuilder setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    public ProductBuilder setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
        return this;
    }
    public Product build(){
        return new Product(this);
    }
}
