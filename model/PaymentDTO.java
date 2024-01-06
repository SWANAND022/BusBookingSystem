package com.anudip.training.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentDTO {
	
	@Id
	private int paymentId;
	
	@Column(name = "bookingId", length = 20, nullable = false)
	@Size(max = 25)
	private int bookingId;
	
	@Column(name = "amountPaid", length = 20, nullable = false)
	@Size(max = 25)
	private double amtPaid;
	
	@Column(name = "bookingDate", length = 20, nullable = false)
	@Size(max = 25)
	private String date;
	
	@Column(name = "bstatus", length = 20, nullable = true)
	@Size(max = 25)
	private String bstatus;

}
