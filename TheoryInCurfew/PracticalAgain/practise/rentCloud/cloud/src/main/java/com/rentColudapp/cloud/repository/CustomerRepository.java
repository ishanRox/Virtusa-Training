package com.rentColudapp.cloud.repository;

import com.rentCloud.rent.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


}
