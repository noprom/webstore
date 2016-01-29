package com.huntdreams.domain.repository;

import com.huntdreams.domain.Customer;

import java.util.List;

/**
 * Created by noprom on 1/22/16.
 */
public interface CustomerRepository {
    List<Customer> getAllCustomers();
    Customer getCustomerById(String customerId);
}
