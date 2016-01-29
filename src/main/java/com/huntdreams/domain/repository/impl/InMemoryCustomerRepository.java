package com.huntdreams.domain.repository.impl;

import com.huntdreams.domain.Customer;
import com.huntdreams.domain.repository.CustomerRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noprom on 1/22/16.
 */
@Repository
public class InMemoryCustomerRepository implements CustomerRepository{

    private List<Customer> listOfCustomers = new ArrayList<Customer>();

    public InMemoryCustomerRepository() {
        Customer noprom = new Customer();
        noprom.setAddress("Bei Jing");
        noprom.setName("noprom");
        noprom.setCustomerId("cus001");

        Customer beitong = new Customer();
        beitong.setAddress("Chong Qing");
        beitong.setCustomerId("cus002");
        beitong.setName("Bei Tong");
        listOfCustomers.add(noprom);
        listOfCustomers.add(beitong);
    }

    public List<Customer> getAllCustomers() {
        return listOfCustomers;
    }

    public Customer getCustomerById(String customerId) {
        Customer customerById = null;
        for (Customer customer : listOfCustomers) {
            if (customer != null && customer.getCustomerId() != null &&
                    customer.getCustomerId().equals(customerId)) {
                customerById = customer;
                break;
            }
        }
        if (customerById == null) {
            throw new IllegalArgumentException("No customer found with the customer id : " + customerId);
        }
        return customerById;
    }
}