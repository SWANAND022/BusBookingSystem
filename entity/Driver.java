package com.anudip.training.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbldriver") 
public class Driver {
	
	@Id
	private int driverId;
	
	@Column(name= "driverName", length = 30, nullable = false)
	@NotBlank(message = "Driver's Name cannot be empty!")
	private String dname;
	
	@Column(name = "driverContact", length = 11, nullable = false)
	private long dcontact;
	
	@ManyToOne
    @JoinColumn(name = "busId", nullable = true)
    @JsonManagedReference
    private Bus bus;
	
	@OneToMany(mappedBy = "driver", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
	@JsonIgnore
	List<Schedule> schedule;

	
}
