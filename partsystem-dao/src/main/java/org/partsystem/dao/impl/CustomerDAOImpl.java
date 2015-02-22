package org.partsystem.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.partsystem.dao.CustomerDAO;
import org.partsystem.dao.model.DAO_Customer;
import org.partsystem.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Krasova Olga
 * Add customer, delete customer, get all customers
 */
@Repository
@Transactional 
public class CustomerDAOImpl implements CustomerDAO{
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addCustomer(Customer customer) {		
		
		DAO_Customer obj = new DAO_Customer();
		obj.setName(customer.getName());

		Session session = sessionFactory.getCurrentSession();
		session.persist(obj);

		customer.setId(obj.getId());
	}

	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		Session session = sessionFactory.getCurrentSession();
		Criteria c = session.createCriteria(DAO_Customer.class);
		c.addOrder(Order.asc("name"));
		List<DAO_Customer> list = c.list();
		for (DAO_Customer obj : list) {
			customers.add(obj.toObject());
		}
		return customers;
	}

	public void removeCustomer(Integer id) {
		DAO_Customer customer = (DAO_Customer) sessionFactory.getCurrentSession().load(
				DAO_Customer.class, id);
	        if (null != customer) {
	            sessionFactory.getCurrentSession().delete(customer);
	        }
		
	}
	

}
