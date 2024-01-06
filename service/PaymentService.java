package com.anudip.training.service;

import java.util.List;

import com.anudip.training.entity.Payment;
import com.anudip.training.model.PaymentDTO;

public interface PaymentService {

	//For adding new Payment Details/records
	PaymentDTO addPayment(Payment payment);
	
	//For getting Payment details/records
	PaymentDTO viewPaymentDetails(int paymentId);
	
	//For update Payment details/records
	PaymentDTO updatePaymentDetails(Payment payment, int paymentId);
	
	//For deleting existing Payment details/records
	void deletePaymentDetails(int paymentId);
	
	//For getting payment details by booking status
	List<PaymentDTO> findPaymentByStatus(String bstatus);
	
	//For getting all bookings List
	List<PaymentDTO> getAllPayments();
}
