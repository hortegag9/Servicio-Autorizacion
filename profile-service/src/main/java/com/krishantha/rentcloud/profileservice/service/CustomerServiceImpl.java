package com.krishantha.rentcloud.profileservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krishantha.rentcloud.commos.model.Customer;
import com.krishantha.rentcloud.profileservice.repository.ICustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerRepository customerRepository;

	@Override
	public Customer save(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> fetchAllProfiles() {

	List<Customer> listaCustomer = customerRepository.findAll();
		
	 return listaCustomer;
	}

	@Override
	public Customer fetchById(int profileId) {
			
	Optional<Customer> customer = customerRepository.findById(profileId);
	
	 if(customer.isPresent()) {
		 return customer.get();
	 }else {
		return null;
	 }
	 
	}

}
