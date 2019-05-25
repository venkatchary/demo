package com.sathya.service;

import com.sathya.entity.Customer;

public interface ICustomerService {
	String  saveCustomer(String customerName,String  address);
	boolean updateCustomer(String customerId,String customerName,String  address);
	boolean deleteCustomer(String  customerId);
	Customer findCustomer(String customerId);
}
