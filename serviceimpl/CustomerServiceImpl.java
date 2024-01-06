package com.anudip.training.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.entity.Customer;
import com.anudip.training.exception.RecordsNotFoundException;
import com.anudip.training.model.CustomerDTO;
import com.anudip.training.repository.CustomerRepository;
import com.anudip.training.service.CustomerService;
import com.anudip.training.util.CustomerConvertor;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository crepo;
	
	@Autowired
	CustomerConvertor cconvertor;
	
	@Override
	public CustomerDTO addCustomer(Customer customer) {
		
		crepo.save(customer);
	    return cconvertor.convertToCustomerDTO(customer);
	}

	@Override
	public CustomerDTO viewCustomerDetails(int customerId) {
		
		Customer customer = crepo.findById(customerId)
                .orElseThrow(() -> new RecordsNotFoundException("Customer with Id '" + customerId + "' Not Found!"));
        return cconvertor.convertToCustomerDTO(customer);
	}

	@Override
	public CustomerDTO updateCustomerDetails(Customer customer, int customerId) {

		Customer updateCustomer = crepo.findById(customerId)
                .orElseThrow(() -> new RecordsNotFoundException("Customer with Id '" + customerId + "' not found.."));

        updateCustomer.setCustomerId(customer.getCustomerId());
        updateCustomer.setCname(customer.getCname());
        updateCustomer.setContact(customer.getContact());
        updateCustomer.setEmail(customer.getEmail());
        updateCustomer.setUsername(customer.getUsername());
        updateCustomer.setPassword(customer.getPassword());
        

        return cconvertor.convertToCustomerDTO(crepo.save(updateCustomer));
		
	}

	@Override
	public void deleteCustomerDetails(int customerId) {

		crepo.findById(customerId)
        .orElseThrow(() -> new RecordsNotFoundException("Customer with Id '" + customerId + "' Not Found!"));
		crepo.deleteById(customerId);;

	}

	@Override
	public List<CustomerDTO> findCustomerByName(String cname) {
		
		List<Customer> customer = crepo.findByNameContaining(cname);

        if (customer.isEmpty()) {
        	
            throw new RecordsNotFoundException("Customer with name '" + cname + "' not found!");
        }

        return cconvertor.convertToCustomerDTOList(customer);
	}

	@Override
	public List<CustomerDTO> getAllCustomers() {
		
		List<Customer> customer = crepo.findAll();

        if (customer.isEmpty()) {
            throw new RecordsNotFoundException("Customer Records Not Found!");
        }

        return cconvertor.convertToCustomerDTOList(customer);
	}

	@Override
	public List<CustomerDTO> findCustomerByUserName(String username) {
		
		List<Customer> customer = crepo.findByUserNameContaining(username);

        if (customer.isEmpty()) {
            throw new RecordsNotFoundException("Customer with username '" + username + "' not found!");
        }

        return cconvertor.convertToCustomerDTOList(customer);
	}

}
