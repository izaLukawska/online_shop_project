package com.youcandev.store.repository;

import com.youcandev.store.model.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ProductRepository {

    private final Map<Long, Product> products = new HashMap<>();
    private static ProductRepository instance;

    private ProductRepository(){}
    private static ProductRepository getInstance() {
        return instance == null ? new ProductRepository() : instance;
    }

    public Product addProduct(Product product){
        return products.put(product.getId(), product);
    }

    public Optional<Product> getProductById(Long id){
        return Optional.ofNullable(products.get(id));
    }

    public List<Product> getAllProducts(){
        return products.values().stream().toList();
    }

    public Optional<Product> deleteProduct(Long id){
        return Optional.ofNullable(products.remove(id));
    }
}
