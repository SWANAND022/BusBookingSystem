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
public class ScheduleDTO {
	
	@Id
	private int scheduleId;
	
	@Column(name = "driverId", length = 20, nullable = true)
	@Size(max = 25)
	private int driverId;
	
	@Column(name = "busId", length = 20, nullable = false)
	@Size(max = 25)
	private int busId;
	
	@Column(name = "startingPoint", length = 20, nullable = false)
	@Size(max = 25)
	private String strtPoint;
	
	@Column(name = "destination", length = 20, nullable = false)
	@Size(max = 25)
	private String destination;
	
	@Column(name = "date", length = 20, nullable = false)
	@Size(max = 25)
	private String date;
	
	@Column(name = "amount", length = 20, nullable = false)
	@Size(max = 25)
	private double amt;

}
