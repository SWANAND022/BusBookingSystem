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
public class DriverDTO {
	
	@Id
	private int driverId;
	
	@Column(name= "driverName", length = 30, nullable = false)
	@Size(max = 25)
	private String dname;
	
	@Column(name = "driverContact", length = 11, nullable = false)
	@Size(max = 25)
	private long dcontact;

}
