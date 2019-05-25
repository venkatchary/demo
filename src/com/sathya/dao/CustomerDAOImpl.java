package com.sathya.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sathya.entity.Customer;
import com.sathya.util.HibernateUtil;

public class CustomerDAOImpl implements ICustomerDAO {
	private  SessionFactory  factory;
	
	public CustomerDAOImpl() {
		factory = HibernateUtil.getSessionFactory();
	}

	public String saveCustomer(Customer customer) {
		Session  session=factory.openSession();
		Transaction tx = session.beginTransaction();
		String customerId=(String)session.save(customer);
		tx.commit();
		session.close();
		return  customerId;
	}

	public boolean updateCustomer(Customer customer) {
		Session  session =factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.update(customer);
			tx.commit();
			return true;
		}catch(Exception e) {
			tx.rollback();
			return  false;
		}finally {
			session.close();
		}
	}

	public boolean deleteCustomer(String customerId) {
		Session  session=factory.openSession();
		Transaction tx=null;
		try {
			Customer  customer=(Customer)session.get(Customer.class, customerId);
			tx =session.beginTransaction();
			session.delete(customer);
			tx.commit();
			return  true;
		}catch(Exception  e) {
			tx.rollback();
			return  false;
		}finally {
			session.close();
		}
	}

	public Customer findCustomer(String customerId) {
		Session  session=factory.openSession();
		Customer  customer=(Customer)session.get(Customer.class, customerId);
		return customer;
	}

}
