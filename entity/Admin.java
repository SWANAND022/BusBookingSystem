package com.anudip.training.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "tbladmin")
public class Admin {
	
	@Id
	private int adminId;

	@Column(name = "adminName", length = 25, nullable = false)
	@NotBlank(message = "Admin Name Cannot be Blank!")
	private String aname;
	
	@Column(name = "contact", length = 25, nullable = true)
	private long contact;
	
	
	@Column(name = "username", length = 25, nullable = false)
	@NotBlank(message = "UserName Cannot be Blank!")
	private String userName;
	
	@Column(name = "password", length = 25, nullable = false)
	@NotBlank(message = "Password Cannot be Blank!")
	private String password;
	
}
