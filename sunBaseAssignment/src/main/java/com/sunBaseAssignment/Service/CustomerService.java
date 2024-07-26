package com.sunBaseAssignment.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sunBaseAssignment.Entity.Customer;

public interface CustomerService {
	
	  public Customer saveCustomer(Customer customer);
	  
	  public Customer updateCustomer(Long id, Customer customerDetails);
	  
	  public List<Customer> findAllCustomer(String search) ;
	
	   public Customer getCustomerById(Long id) ;
	
	   public void deleteCustomer(Long id) ;
	   
	   public List<Customer> findByLastName(String value);

}
