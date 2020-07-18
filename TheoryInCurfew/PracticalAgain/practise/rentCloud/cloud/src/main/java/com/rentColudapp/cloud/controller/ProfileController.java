package com.rentColudapp.cloud.controller;

import com.rentCloud.rent.model.Customer;
import com.rentColudapp.cloud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

    @Autowired
    CustomerService customerService;

    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
}
