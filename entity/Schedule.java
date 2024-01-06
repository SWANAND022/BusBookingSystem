package com.anudip.training.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblschedule")
public class Schedule {
	
	@Id
	private int scheduleId;
	
	@Column(name = "driverId", length = 20, nullable = true)
	private int driverId;
	
	@Column(name = "busId", length = 20, nullable = false)
	private int busId;
	
	@Column(name = "startingPoint", length = 20, nullable = false)
	@NotBlank(message = "Starting Point cannot be Blank!")
	private String strtPoint;
	
	@Column(name = "destination", length = 20, nullable = false)
	@NotBlank(message = "destination cannot be Blank!")
	private String destination;
	
	@Column(name = "date", length = 20, nullable = false)
	@NotBlank(message = "date cannot be Blank!")
	private String date;
	
	@Column(name = "amount", length = 20, nullable = false)
	private double amt;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "busId", referencedColumnName = "busId", insertable = false, updatable = false)
    @JsonManagedReference
    private Bus bus;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "driverId", referencedColumnName = "driverId", insertable = false, updatable = false)
    @JsonManagedReference
    private Driver driver;

}
