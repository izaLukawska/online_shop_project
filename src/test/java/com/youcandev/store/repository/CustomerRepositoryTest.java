package com.youcandev.store.repository;

import com.youcandev.store.model.Customer;

import com.youcandev.store.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryTest {

    private final CustomerRepository customerRepository = CustomerRepository.getInstance();
    private static final Customer CUSTOMER = new Customer(1L, "Iza", "Lukawska", "iza@gmail.com", List.of(Mockito.mock(Order.class)));


    @Test
    void shouldReturnEmptyCollectionIfNoUserAdded(){
        //given

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
        int expectedSize = 1;

        //when
        customerRepository.addCustomer(CUSTOMER);
        List<Customer> result = customerRepository.getAllCustomers();

        //then
        assertAll(() ->{
            assertFalse(result.isEmpty());
            assertEquals(expectedSize,1);
        });
    }
    @Test
    void shouldReturnCorrectSizeForAddedCustomers(){
        //given
        final int expectedSize = 1;

        //when
        customerRepository.addCustomer(CUSTOMER);
        List<Customer> result = customerRepository.getAllCustomers();

        //then
        assertEquals(expectedSize, result.size());
    }

    @Test
    void shouldDeleteAddedCustomerById(){
        //given
        customerRepository.addCustomer(CUSTOMER);

        //when
        customerRepository.deleteCustomer(CUSTOMER.getId());

        //then
        assertTrue(customerRepository.getAllCustomers().isEmpty());
    }

    @Test
    void shouldReturnEmptyOptionalIfNoSuchCustomerExists(){
        //given
        Long givenId = 1L;

        //when
        Optional<Customer> result = customerRepository.deleteCustomer(givenId);

        //then
        assertTrue(result.isEmpty());
    }
}
