package com.krishantha.rentcloud.profileservice.repository;

import com.krishantha.rentcloud.commos.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {

}
