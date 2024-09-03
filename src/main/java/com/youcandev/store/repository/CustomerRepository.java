package com.youcandev.store.repository;

import com.youcandev.store.model.Customer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CustomerRepository {
    private final Map<Long, Customer> customers = new HashMap<>();
    private static CustomerRepository instance;

    private CustomerRepository() {}
    private static CustomerRepository getInstance(){

        return instance == null ? new CustomerRepository() : instance;
    }
    public Customer addCustomer(Customer customer){
        return customers.put(customer.getId(), customer);
    }

    public Optional<Customer> getCustomerById(Long id){
        return Optional.ofNullable(customers.get(id));
    }

    public List<Customer> getAllCustomers(){

        return customers.values().stream().toList();
    }

    public Optional<Customer> deleteCustomer(Long id){
        return Optional.ofNullable(customers.remove(id));
    }
}
