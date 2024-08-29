package com.youcandev.store.model;

import java.math.BigDecimal;

public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private int quantityInStock;

    private Product() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    public static class ProductBuilder{
        private Product product = new Product();

        public static ProductBuilder builder(){
            return new ProductBuilder();
        }
        public ProductBuilder id(Long id){
            product.setId(id);
            return this;
        }
        public ProductBuilder name(String name){
            product.setName(name);
            return this;
        }
        public ProductBuilder description(String description){
            product.setDescription(description);
            return this;
        }
        public ProductBuilder price(BigDecimal price){
            product.setPrice(price);
            return this;
        }
        public ProductBuilder quantityInStock(int quantity){
            product.setQuantityInStock(quantity);
            return this;
        }

        public Product build(){
            return product;
        }

    }
}

