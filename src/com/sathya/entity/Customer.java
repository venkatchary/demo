package com.sathya.entity;

public class Customer {
	private  String  customerId;
	private  String  customerName;
	private  String  address;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public   String   toString() {
		return  "Customer[customerId="+customerId+", customerName="+customerName+", address="+address+"]";
	}

}
