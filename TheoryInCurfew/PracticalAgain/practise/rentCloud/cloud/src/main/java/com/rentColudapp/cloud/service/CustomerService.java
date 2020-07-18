package com.rentColudapp.cloud.service;

import com.rentCloud.rent.model.Customer;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {

    Customer save(Customer customer);
}
