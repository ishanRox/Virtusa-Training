package com.rentColudapp.cloud.service;

import com.rentCloud.rent.model.Customer;
import com.rentCloud.rent.model.Vehicle;
import com.rentColudapp.cloud.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById(id).get();
    }


}
