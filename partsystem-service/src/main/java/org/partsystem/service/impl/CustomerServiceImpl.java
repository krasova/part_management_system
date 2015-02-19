package org.partsystem.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.partsystem.model.Customer;
import org.partsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.partsystem.dao.CustomerDAO;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	
	@Autowired
    private CustomerDAO customerDAO;

	@Transactional
	public void addCustomer(Customer customer) {
		customerDAO.addCustomer(customer);
		
	}

	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Transactional
	public void removeCustomer(Integer id) {
		customerDAO.removeCustomer(id);
		
	}


}
