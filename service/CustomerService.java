package com.anudip.training.service;

import java.util.List;


import com.anudip.training.entity.Customer;
import com.anudip.training.model.CustomerDTO;


public interface CustomerService {

	//For adding new Customer Details/records
	CustomerDTO addCustomer(Customer customer);
	
	//For getting Customer details/records
	CustomerDTO viewCustomerDetails(int customerId);
	
	//For update Customer details/records
	CustomerDTO updateCustomerDetails(Customer customer, int customerId);
	
	//For deleting existing Customer details/records
	void deleteCustomerDetails(int customerId);
	
	//Finding Customer By name
	List<CustomerDTO> findCustomerByName(String customerName);
	
	//Getting All Customer List
	List<CustomerDTO> getAllCustomers();

	//Finding Customer By Username
	List<CustomerDTO> findCustomerByUserName(String username);

}
