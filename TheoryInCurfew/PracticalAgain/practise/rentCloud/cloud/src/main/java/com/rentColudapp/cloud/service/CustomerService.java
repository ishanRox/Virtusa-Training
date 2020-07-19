package com.rentColudapp.cloud.service;

import com.rentCloud.rent.model.Customer;
import com.rentCloud.rent.model.Vehicle;
import org.springframework.stereotype.Service;

public interface CustomerService {

    Customer save(Customer customer);

    Customer findById(Integer id);
}
