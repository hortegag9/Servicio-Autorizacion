package com.krishantha.rentcloud.profileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krishantha.rentcloud.commos.model.Customer;
import com.krishantha.rentcloud.profileservice.service.ICustomerService;

@RestController
@RequestMapping(value="/services")
public class ProfileController {
	
	@Autowired
	ICustomerService customerService;
	/* before video 013
	@RequestMapping(value="/profile", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('create_profile')")
	public Customer save(@RequestBody Customer customer) {		
		return customerService.save(customer);		
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public Customer fetch(@RequestParam int profileId) {
	        return customerService.fetchById(profileId);
	}
	
	@RequestMapping(value = "/profiles", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_operator')")
    public List<Customer> fetch() {
        return customerService.fetchAllProfiles();
    }*/
	
	@RequestMapping(value="/customers", method = RequestMethod.POST)
	@PreAuthorize("hasAuthority('create_profile')")
	public Customer save(@RequestBody Customer customer) {		
		return customerService.save(customer);		
	}
	
	@RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
	public Customer fetch(@PathVariable(value="id") int customerId) {
	        return customerService.fetchById(customerId);
	}
	
	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ROLE_operator')")
    public List<Customer> fetch() {
        return customerService.fetchAllProfiles();
	}
	

}
