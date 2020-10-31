package com.krishantha.rentcloud.profileservice.service;

import java.util.List;
import java.util.Optional;

import com.krishantha.rentcloud.commos.model.Customer;

public interface ICustomerService {
	
   public abstract Customer save(Customer customer);
   public abstract List<Customer> fetchAllProfiles();
   public abstract Customer fetchById(int profileId);
   
}
