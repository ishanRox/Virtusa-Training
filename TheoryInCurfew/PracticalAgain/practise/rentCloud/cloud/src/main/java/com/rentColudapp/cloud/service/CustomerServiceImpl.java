package com.rentColudapp.cloud.service;

import com.rentCloud.rent.model.Customer;
import com.rentColudapp.cloud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Customer save(Customer customer) {


        return customerRepository.save(customer);
    }
}
