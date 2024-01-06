package com.anudip.training.controller;


import com.anudip.training.entity.Customer;
import com.anudip.training.model.CustomerDTO;
import com.anudip.training.service.CustomerService;
import com.anudip.training.util.CustomerConvertor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	CustomerService cs;
	
	@Autowired
	CustomerConvertor cconvertor;
	
	@PostMapping("/saveCustomer")
	public CustomerDTO saveCustomer(@RequestBody CustomerDTO cdto)
	{
		
		Customer customer1 = cconvertor.convertToCustomerEntity(cdto);
		
		return cs.addCustomer(customer1);
	}
	
	@GetMapping("/getCustomerDetails/{customerId}")
	public CustomerDTO getCustomerDetails(@PathVariable("customerId") int customerId)
	{
		return cs.viewCustomerDetails(customerId);
	}
	
	@PutMapping("/editCustomerDetails/{customerId}")
	public CustomerDTO editCustomerDetails(@PathVariable("customerId")int customerId,@RequestBody CustomerDTO cdto)
	{
		Customer customer = cconvertor.convertToCustomerEntity(cdto);
        return cs.updateCustomerDetails(customer, customerId);
	}

	@DeleteMapping("/deleteCustomerDetails/{customerId}")
	public ResponseEntity<String> deleteCustomerDetails(@PathVariable("customerId") int customerId)
	{
		cs.deleteCustomerDetails(customerId);
		return new ResponseEntity<String>("deleted Successfully..",HttpStatus.OK);
	}
	
	@GetMapping("/findCustomerByName/{cname}")
    public List<CustomerDTO> findCustomerByName(@PathVariable("cname") String cname) {
       
		return cs.findCustomerByName(cname);
    }

    @GetMapping("/getAllCustomers")
    public List<CustomerDTO> getAllCustomers() {
       
    	return cs.getAllCustomers();
    }
    
    @GetMapping("/findCustomerByUserName/{username}")
    public List<CustomerDTO> findCustomerByUserName(@PathVariable("username") String username) {
        
    	return 	cs.findCustomerByUserName(username);

    }

}
