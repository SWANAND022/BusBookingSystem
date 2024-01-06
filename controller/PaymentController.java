package com.anudip.training.controller;

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

import com.anudip.training.entity.Payment;
import com.anudip.training.model.PaymentDTO;
import com.anudip.training.service.PaymentService;
import com.anudip.training.util.PaymentConvertor;

@RestController
@RequestMapping("/Payment")
public class PaymentController {
	
	@Autowired
	PaymentService ps;
	
	@Autowired
	PaymentConvertor pconvertor;
	
	@PostMapping("/savePayment")
	public PaymentDTO savePayment(@RequestBody PaymentDTO pdto)
	{
		Payment payment1 = pconvertor.convertToPaymentEntity(pdto);
		
		return ps.addPayment(payment1);
	}
	
	@GetMapping("/getPaymentDetails/{paymentId}")
	public PaymentDTO getPaymentDetails(@PathVariable("paymentId") int paymentId)
	{
		return ps.viewPaymentDetails(paymentId);
	}
	
	@PutMapping("/editPaymentDetails/{paymentId}")
	public PaymentDTO editPaymentDetails(@PathVariable("paymentId")int paymentId,@RequestBody PaymentDTO pdto)
	{
		Payment payment1 = pconvertor.convertToPaymentEntity(pdto);
        return ps.updatePaymentDetails(payment1, paymentId);
	}

	@DeleteMapping("/deletePaymentDetails/{paymentId}")
	public ResponseEntity<String> deletePaymentDetails(@PathVariable("paymentId") int paymentId)
	{
		ps.deletePaymentDetails(paymentId);
		return new ResponseEntity<String>("deleted Successfully..",HttpStatus.OK);
	}
	
	@GetMapping("/findPaymentByStatus/{bstatus}")
    public List<PaymentDTO> findPaymentByStatus(@PathVariable("bstatus") String bstatus) {
        
		return ps.findPaymentByStatus(bstatus);
    }

    @GetMapping("/getAllPayments")
    public List<PaymentDTO> getAllPayments() {
       
    	return ps.getAllPayments();
    }

}
