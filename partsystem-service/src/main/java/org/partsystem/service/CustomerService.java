package org.partsystem.service;

import java.util.List;

import org.partsystem.model.Customer;

public interface CustomerService{

	public void addCustomer(Customer customer);

    public List<Customer> getCustomers();

    public void removeCustomer(Integer id);
}
