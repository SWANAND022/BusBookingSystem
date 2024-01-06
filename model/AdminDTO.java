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
public class AdminDTO {
	
	@Id
	private int adminId;

	@Column(name = "adminName", length = 25, nullable = false)
	@Size(max = 25)
	private String aname;
	
	@Column(name = "contact", length = 25, nullable = false)
	@Size(max = 25)
	private long contact;
	
	@Column(name = "username", length = 25, nullable = false)
	@Size(max = 25)
	private String userName;
	
	@Column(name = "password", length = 25, nullable = false)
	@Size(max = 25)
	private String password;

}
