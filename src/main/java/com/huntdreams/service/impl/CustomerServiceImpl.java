package com.huntdreams.service.impl;

import com.huntdreams.domain.repository.Customer;
import com.huntdreams.domain.repository.CustomerRepository;
import com.huntdreams.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by noprom on 1/22/16.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }
}
