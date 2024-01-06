package com.anudip.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anudip.training.entity.Driver;
import com.anudip.training.model.DriverDTO;
import com.anudip.training.service.DriverService;
import com.anudip.training.util.DriverConvertor;

@RestController
@RequestMapping("/Driver")
public class DriverController {

	@Autowired
	DriverService ds;
	
	@Autowired
	DriverConvertor dconvertor;
	
	@PostMapping("/saveDriver")
	public DriverDTO saveDriver(@RequestBody DriverDTO ddto)
	{
		Driver driver1 = dconvertor.convertToDriverEntity(ddto);
		
		return ds.addDriver(driver1);
	}
	
	@GetMapping("/getDriverDetails/{driverId}")
	public DriverDTO getDriverDetails(@PathVariable("driverId") int driverId)
	{
		return ds.viewDriverDetails(driverId);
	}
	
	@PutMapping("/editDriverDetails/{driverId}")
	public DriverDTO editDriverDetails(@PathVariable("driverId")int driverId,@RequestBody DriverDTO ddto)
	{
		
		Driver driver1 = dconvertor.convertToDriverEntity(ddto);
        return ds.updateDriverDetails(driver1, driverId);
	}

	@DeleteMapping("/deleteDriverDetails/{driverId}")
	public ResponseEntity<String> deleteDriverDetails(@PathVariable("driverId") int driverId)
	{
		ds.deleteDriverDetails(driverId);
		return new ResponseEntity<String>("deleted Successfully..",HttpStatus.OK);
	}
	
	@GetMapping("/findDriversByName/{dname}")
    public List<DriverDTO> findDriversByName(@PathVariable("dname") String dname) {
       
		return ds.findDriversByName(dname);
    }

    @GetMapping("/getAllDrivers")
    public List<DriverDTO> getAllDrivers() {
    	
        return ds.getAllDrivers();
    }
    
    @GetMapping("/findDriversByContact/{dcontact}")
    public List<DriverDTO> findDriversByContact(@PathVariable("dcontact") long dcontact) {
        
    	return ds.findDriversByContact(dcontact);
    }
}
