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
public class BusDTO {
	
	@Id
	private int busId;
	
	@Column(name = "busNo", length = 20, nullable = false)
	@Size(max = 25)
	private String busNo;
	
	@Column(name = "capacity", length = 20, nullable = true)
	@Size(max = 25)
	private int capacity;
	
	@Column(name = "busType", length = 20, nullable = true)
	@Size(max = 25)
	private String type;

	

}
