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
public class BookingsDTO {
	
	@Id
	private int bookingId;
	
	@Column(name = "customerId", length = 10, nullable = true)
	@Size(max = 25)
	private int cid;
	
	@Column(name = "noOfSeats", length = 20, nullable = true)
	@Size(max = 25)
	private int noOfSeats;
	
	@Column(name = "datOfBooking", length = 20, nullable = false)
	@Size(max = 25)
	private String dateOfBooking;
	
	@Column(name = "totalAmt", length = 20, nullable = true)
	@Size(max = 25)
	private double totalAmount;

}
