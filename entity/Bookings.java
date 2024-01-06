package com.anudip.training.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblbookings")
public class Bookings {
	
	@Id
	private int bookingId;
	
	@Column(name = "customerId", length = 10, nullable = true)
	private int cid;
	
	@Column(name = "noOfSeats", length = 20, nullable = true)
	private int noOfSeats;
	
	@Column(name = "datOfBooking", length = 20, nullable = false)
	@NotBlank(message = "Date Of Booking cannot be blank!")
	private String dateOfBooking;
	
	@Column(name = "totalAmt", length = 20, nullable = true)
	private double totalAmount;
	
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId", referencedColumnName = "customerId", insertable = false, updatable = false)
    @JsonManagedReference
    private Customer customer;
	
	@OneToOne(mappedBy = "bookings", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Payment payment;
	
}
