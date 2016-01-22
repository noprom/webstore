package com.huntdreams.service;

import com.huntdreams.domain.repository.Customer;

import java.util.List;

/**
 * Created by noprom on 1/22/16.
 */
public interface CustomerService {
    List<Customer> getAllCustomers();
}
