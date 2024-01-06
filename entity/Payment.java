package com.anudip.training.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblpayment")
public class Payment {
	
	@Id
	private int paymentId;
	
	@Column(name = "bookingId", length = 20, nullable = false)
	private int bookingId;
	
	@Column(name = "amountPaid", length = 20, nullable = false)
	private double amtPaid;
	
	@Column(name = "bookingDate", length = 20, nullable = false)
	private String date;
	
	@Column(name = "bstatus", length = 20, nullable = true)
	private String bstatus;
	
	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bookingId", referencedColumnName = "bookingId", insertable = false, updatable = false)
    @JsonBackReference
    private Bookings bookings;

}
