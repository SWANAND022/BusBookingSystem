package com.anudip.training.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.entity.Payment;
import com.anudip.training.exception.RecordsNotFoundException;
import com.anudip.training.model.PaymentDTO;
import com.anudip.training.repository.PaymentRepository;
import com.anudip.training.service.PaymentService;
import com.anudip.training.util.PaymentConvertor;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentRepository prepo;
	
	@Autowired
	PaymentConvertor pconvertor;
	
	@Override
	public PaymentDTO addPayment(Payment payment) {
		
		prepo.save(payment);
	    return pconvertor.convertToPaymentDTO(payment);
	}

	@Override
	public PaymentDTO viewPaymentDetails(int paymentId) {
		
		 Payment payment = prepo.findById(paymentId)
	                .orElseThrow(() -> new RecordsNotFoundException("Payment with Id '" + paymentId + "' Not Found!"));
	     return pconvertor.convertToPaymentDTO(payment);
	}

	@Override
	public PaymentDTO updatePaymentDetails(Payment payment, int paymentId) {
		
		Payment updatePayment = prepo.findById(paymentId)
                .orElseThrow(() -> new RecordsNotFoundException("Payment with Id '" + paymentId + "' Not Found!") );   
		
		updatePayment.setPaymentId(payment.getPaymentId());
		updatePayment.setBookingId(payment.getBookingId());
		updatePayment.setAmtPaid(payment.getAmtPaid());
		updatePayment.setDate(payment.getDate());
		updatePayment.setBstatus(payment.getBstatus());
		
		return pconvertor.convertToPaymentDTO(prepo.save(updatePayment));
		
	}

	@Override
	public void deletePaymentDetails(int paymentId) {
		
		prepo.findById(paymentId)
        .orElseThrow(() -> new RecordsNotFoundException("Payment with Id '" + paymentId + "' Not Found!"));
		prepo.deleteById(paymentId);
	}

	@Override
	public List<PaymentDTO> findPaymentByStatus(String bstatus) {
		
		List<Payment> payment =prepo.findByStatusContaining(bstatus);

        if (payment.isEmpty()) {
        	
            throw new RecordsNotFoundException("Payment with Status '" + bstatus + "' not found!");
        }

        return pconvertor.convertToPaymentDTOList(payment);
		
	}

	@Override
	public List<PaymentDTO> getAllPayments() {
		
		List<Payment> payment = prepo.findAll();

        if (payment.isEmpty()) {
            throw new RecordsNotFoundException("Payment Records Not Found!");
        }

        return pconvertor.convertToPaymentDTOList(payment);
	}

}
