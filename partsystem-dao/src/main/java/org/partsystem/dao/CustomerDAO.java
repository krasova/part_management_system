package org.partsystem.dao;

import java.util.List;
import org.partsystem.model.Customer;

public interface CustomerDAO {
	
	public void addCustomer(Customer customer);

    public List<Customer> getCustomers();

    public void removeCustomer(Integer id);
}
