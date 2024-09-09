package com.youcandev.store.repository;

import com.youcandev.store.model.Customer;

import com.youcandev.store.model.Order;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerRepositoryTest {

    private CustomerRepository customerRepository;
    private static final Customer customer = new Customer(1L, "Iza", "Lukawska", "iza@gmail.com", List.of(Mockito.mock(Order.class)));

    @Test
    void shouldReturnEmptyCollectionIfNoUserAdded(){
        //given
        customerRepository = CustomerRepository.getInstance();

        //when
        List<Customer> customers = customerRepository.getAllCustomers();

        //then
        assertAll(() -> {
            assertNotNull(customers);
            assertTrue(customers.isEmpty());
        });
    }
    @Test
    void shouldReturnAddedCustomers(){
        //given
        final int expectedSize = 1;
        customerRepository = CustomerRepository.getInstance();

        //when
        customerRepository.addCustomer(customer);

        //then
        assertEquals(expectedSize, customerRepository.getAllCustomers().size());
    }

    @Test
    void shouldDeleteAddedCustomerById(){
        //given
        customerRepository = CustomerRepository.getInstance();
        customerRepository.addCustomer(customer);

        //when
        customerRepository.deleteCustomer(customer.getId());

        //then
        assertTrue(customerRepository.getAllCustomers().isEmpty());
    }

    @Test
    void shouldReturnEmptyOptionalIfNoSuchCustomerExists(){
        //given
        customerRepository = CustomerRepository.getInstance();
        Long expectedId = 1L;
        Optional<Customer> customer;

        //when
        customer = customerRepository.getCustomerById(expectedId);

        //then
        assertTrue(customer.isEmpty());
    }
}
