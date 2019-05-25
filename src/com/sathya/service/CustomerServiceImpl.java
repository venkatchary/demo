package com.sathya.service;

import com.sathya.dao.CustomerDAOImpl;
import com.sathya.dao.ICustomerDAO;
import com.sathya.entity.Customer;

public class CustomerServiceImpl implements ICustomerService {
	private  ICustomerDAO  dao;
	public CustomerServiceImpl() {
		dao=new CustomerDAOImpl();
	}

	public String saveCustomer(String customerName, String address) {
		Customer  customer=new Customer();
		customer.setCustomerName(customerName);
		customer.setAddress(address);
		return  dao.saveCustomer(customer);
	}

	public boolean updateCustomer(String customerId, String customerName, String address) {
		Customer  customer=new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);
		customer.setAddress(address);
		return dao.updateCustomer(customer);
	}

	public boolean deleteCustomer(String customerId) {
		return  dao.deleteCustomer(customerId);
	}

	public Customer findCustomer(String customerId) {
		return  dao.findCustomer(customerId);
	}

}
