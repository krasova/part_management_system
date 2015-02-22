package org.partsystem.service.impl;

import java.util.List;

import org.partsystem.model.Customer;
import org.partsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.partsystem.dao.CustomerDAO;

/**
 * @author Krasova Olga
 * Add customer, delete customer, get all customers
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
    private CustomerDAO customerDAO;

	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
		
	}

	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	public void removeCustomer(Integer id) {
		customerDAO.removeCustomer(id);
		
	}


}
