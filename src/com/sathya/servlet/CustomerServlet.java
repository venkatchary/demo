package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sathya.entity.Customer;
import com.sathya.service.CustomerServiceImpl;
import com.sathya.service.ICustomerService;

public class CustomerServlet extends HttpServlet {
	private  ICustomerService service;
	public  CustomerServlet() {
		service = new CustomerServiceImpl();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter  out=response.getWriter();
		String option=request.getParameter("opt");
		if(option.equals("add")) {
			String customerName=request.getParameter("custname");
			String address=request.getParameter("address");
			String customerId=service.saveCustomer(customerName, address);
			out.println("Customer is saved successfully with customer id : "+customerId);
		}
		else if(option.equals("update")) {
			String customerId=request.getParameter("custid");
			String customerName=request.getParameter("custname");
			String address=request.getParameter("address");
			boolean flag=service.updateCustomer(customerId, customerName, address);
			if(flag == true) {
				out.println("Customer details are updated.");
			}else {
				out.println("sorry, customer is not updated.");
			}
		}
		else if(option.equals("delete")) {
			String customerId=request.getParameter("custid");
			boolean flag=service.deleteCustomer(customerId);
			if(flag==true) {
				out.println("customer is deleted.");
			}else {
				out.println("Sorry, customer does not exist");
			}
		}
		else {
			String customerId=request.getParameter("custid");
			Customer  customer=service.findCustomer(customerId);
			out.println("customer id = "+customer.getCustomerId());
			out.println("<br>");
			out.println("customer name = "+customer.getCustomerName());
			out.println("<br>");
			out.println("address = "+customer.getAddress());
			out.println("<br>");
		}
		out.println("<a href=index.html>goto index page</a>");
		out.close();
	}
}
