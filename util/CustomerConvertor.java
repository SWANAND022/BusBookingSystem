package com.anudip.training.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.entity.Customer;
import com.anudip.training.model.CustomerDTO;

@Component
public class CustomerConvertor {
	
	//converting Customer Entity to Customer DTO
	
	public CustomerDTO convertToCustomerDTO(Customer customer){
		
		CustomerDTO cdto = new CustomerDTO();
		if(customer != null)
		{
			//copy data from Customer to CustomerDTO
			BeanUtils.copyProperties(customer, cdto);
			
		}
		return cdto;
	}
	
	//converting Customer dto to Customer entity
	public Customer convertToCustomerEntity(CustomerDTO cdto){
			
		Customer customer = new Customer();
			if(cdto != null)
			{
				//copy data from Customer to CustomerDTO
				BeanUtils.copyProperties(cdto, customer);
				
			}
			return customer;
		}
	
	 // converting List of Customer Entities to List of CustomerDTOs
    public List<CustomerDTO> convertToCustomerDTOList(List<Customer> customer) {
        return customer.stream()
                .map(this::convertToCustomerDTO)
                .collect(Collectors.toList());
    }


}
