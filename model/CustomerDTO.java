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
public class CustomerDTO {
	
	@Id
	private int customerId;
	
	@Column(name = "cname", length = 20, nullable = false)
	@Size(max = 25)
	private String cname;
	
	@Column(name = "contact", length = 20, nullable = true)
	//@Size(max = 11)
	private long contact;
	
	@Column(name = "email", length = 20, nullable = true)
	@Size(max = 25)
	private String email;
	
	@Column(name = "username", length = 20, nullable = false)
	@Size(max = 25)
	private String username;
	
	@Column(name = "password", length = 20, nullable = false)
	@Size(max = 25)
	private String password;
	

}
