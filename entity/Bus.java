package com.anudip.training.entity;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tblbus")
public class Bus {
	
	@Id
	private int busId;
	
	@Column(name = "busNo", length = 20, nullable = false)
	@NotBlank(message = "Bus No. cannot be blank!")
	private String busNo;
	
	@Column(name = "capacity", length = 20, nullable = true)
	private int capacity;
	
	@Column(name = "busType", length = 20, nullable = true)
	private String type;
	
	@OneToMany(mappedBy = "bus", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Driver> driver;
	
	@OneToMany(mappedBy = "bus", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    List<Schedule> schedule;
	
	
	
}
