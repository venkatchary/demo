package com.sathya.dao;

import com.sathya.entity.Customer;

public interface ICustomerDAO {
	String   saveCustomer(Customer  customer);
	
	boolean  updateCustomer(Customer  customer);
	
	boolean  deleteCustomer(String  customerId);
	
	Customer findCustomer(String customerId);

}



