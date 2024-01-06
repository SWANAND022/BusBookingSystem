package com.anudip.training.service;

import java.util.List;

import com.anudip.training.entity.Driver;
import com.anudip.training.model.DriverDTO;

public interface DriverService {
	
	//adding new Driver Details/records
	DriverDTO addDriver(Driver driver);
	
	//getting Driver details/records
	DriverDTO viewDriverDetails(int driverId);
	
	//update Driver details/records
	DriverDTO updateDriverDetails(Driver driver, int driverId);
	
	//deleting existing Driver details/records
	void deleteDriverDetails(int driverId);
	
	//Finding Driver By name
	List<DriverDTO> findDriversByName(String dname);
	
	//Getting All Driver List
	List<DriverDTO> getAllDrivers();
	
	//Get Driver By Contact
	List<DriverDTO> findDriversByContact(long dcontact);


}
