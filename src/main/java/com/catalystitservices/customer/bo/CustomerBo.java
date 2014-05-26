package com.catalystitservices.customer.bo;
 
import java.util.List;
 

import com.catalystitservices.customer.model.Customer;
 
public interface CustomerBo{
 
	void addCustomer(Customer customer);
 
	List<Customer> findAllCustomer();
 
}