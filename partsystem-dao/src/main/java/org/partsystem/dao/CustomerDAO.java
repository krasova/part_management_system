package org.partsystem.dao;

import java.util.List;
import org.partsystem.model.Customer;


/**
 * @author Krasova Olga
 * Interface for @CustomerDAOImpl
 */
public interface CustomerDAO {
	
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
