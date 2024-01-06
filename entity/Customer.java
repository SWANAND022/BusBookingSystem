package com.anudip.training.entity;

import java.util.List;

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
@Table(name = "tblcustomer")
public class Customer {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;
	
	@Column(name = "cname", length = 20, nullable = false)
	@NotBlank(message = "Customer name cannot be blank!")
	private String cname;
	
	@Column(name = "contact", length = 20, nullable = true)
	private long contact;
	
	@Column(name = "email", length = 20, nullable = true)
	private String email;
	
	@Column(name = "username", length = 20, nullable = false )
	@NotBlank(message = "Username cannot be blank!")
	private String username;
	
	@Column(name = "password", length = 20, nullable = false)
	@NotBlank(message = "Password cannot be blank!")
	private String password;
	
	@OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    @JsonIgnore
    List<Bookings> bookings;

}
