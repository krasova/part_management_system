package org.partsystem.service;

import java.util.List;

import org.partsystem.model.Customer;

/**
 * @author Krasova Olga
 * Interface for @CustomerServiceImpl
 */
public interface CustomerService{
	
	/**
	 * Add new customer
	 * @param @Customer
	 */
	public void addCustomer(Customer customer);
	
    /**
     * Get all customers
     * @return @List<Customer>
     */
    public List<Customer> getCustomers();

    /**
     * Delete customer 
     * @param id
     */
    public void removeCustomer(Integer id);
}
