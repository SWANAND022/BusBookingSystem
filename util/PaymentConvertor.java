package com.anudip.training.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.entity.Payment;
import com.anudip.training.model.PaymentDTO;

@Component
public class PaymentConvertor {
	
	//converting Payment Entity to Payment DTO
	
			public PaymentDTO convertToPaymentDTO(Payment payment){
				
				PaymentDTO pdto = new PaymentDTO();
				if(payment != null)
				{
					//copy data from Payment to PaymentDTO
					BeanUtils.copyProperties(payment, pdto);
					
				}
				return pdto;
			}
			
			//converting Payment dto to Payment entity
			public Payment convertToPaymentEntity(PaymentDTO pdto){
					
					Payment payment = new Payment();
					if(pdto != null)
					{
						//copy data from Payment to PaymentDTO
						BeanUtils.copyProperties(pdto, payment);
						
					}
					return payment;
				}
			
			 // converting List of Payment Entities to List of PaymentDTOs
		    public List<PaymentDTO> convertToPaymentDTOList(List<Payment> payments) {
		        return payments.stream()
		                .map(this::convertToPaymentDTO)
		                .collect(Collectors.toList());
		    }

}
