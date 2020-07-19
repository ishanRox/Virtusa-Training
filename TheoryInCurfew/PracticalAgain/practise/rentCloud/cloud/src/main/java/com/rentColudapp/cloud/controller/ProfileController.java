package com.rentColudapp.cloud.controller;

import com.rentCloud.rent.model.Customer;
import com.rentCloud.rent.model.Vehicle;
import com.rentColudapp.cloud.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/services")
public class ProfileController {

    @Autowired
    CustomerService customerService;

    @PostMapping(value = "/profile")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping(value = "/getProfile/{id}")
    public Customer get(@PathVariable Integer id) {
        System.out.println(id);
        return customerService.findById(id);
    }

    @GetMapping(value = "/cus")
    public Customer customer() {
        Customer customer = new Customer();
        customer.setDlNumber("sdf1");
        customer.setFirstName("hello");
        customer.setId(123);

        return customer;
    }

}
