package com.anudip.training.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.entity.Driver;
import com.anudip.training.exception.RecordsNotFoundException;
import com.anudip.training.model.DriverDTO;
import com.anudip.training.repository.DriverRepository;
import com.anudip.training.service.DriverService;
import com.anudip.training.util.DriverConvertor;

@Service
public class DriverServiceImpl implements DriverService {

	@Autowired
	DriverRepository drepo;
	
	@Autowired
	DriverConvertor dconvertor;
	
	@Override
	public DriverDTO addDriver(Driver driver) {
		
		drepo.save(driver);
	    return dconvertor.convertToDriverDTO(driver);
	}

	@Override
	public DriverDTO viewDriverDetails(int driverId) {
		
		Driver driver = drepo.findById(driverId)
                .orElseThrow(() -> new RecordsNotFoundException("Driver with Id '" + driverId + "' Not Found!"));
     return dconvertor.convertToDriverDTO(driver);
	}

	@Override
	public DriverDTO updateDriverDetails(Driver driver, int driverId) {
		
		Driver updateDriver = drepo.findById(driverId)
                .orElseThrow(() -> new RecordsNotFoundException("Driver with Id '" + driverId + "' Not Found!") ); 
		
		updateDriver.setDriverId(driver.getDriverId());
		updateDriver.setDname(driver.getDname());
		updateDriver.setDcontact(driver.getDcontact());
		
		return dconvertor.convertToDriverDTO(drepo.save(updateDriver));
		
	}

	@Override
	public void deleteDriverDetails(int driverId) {
		
		drepo.findById(driverId)
        .orElseThrow(() -> new RecordsNotFoundException("Driver with Id '" + driverId + "' Not Found!"));
		drepo.deleteById(driverId);
	}

	@Override
	public List<DriverDTO> findDriversByName(String dname) {
		
		List<Driver> driver = drepo.findByNameContaining(dname);

        if (driver.isEmpty()) {
        	
            throw new RecordsNotFoundException("Driver with name '" + dname + "' not found!");
        }

        return dconvertor.convertToDriverDTOList(driver);
	}

	@Override
	public List<DriverDTO> getAllDrivers() {
		
		List<Driver> driver = drepo.findAll();

        if (driver.isEmpty()) {
            throw new RecordsNotFoundException("Driver Records Not Found!");
        }

        return dconvertor.convertToDriverDTOList(driver);
	}

	@Override
	public List<DriverDTO> findDriversByContact(long dcontact) {
		
		List<Driver> driver = drepo.findByContactContaining(dcontact);

        if (driver.isEmpty()) {
            throw new RecordsNotFoundException("Driver with contact '" + dcontact + "' not found!");
        }

        return dconvertor.convertToDriverDTOList(driver);
	}
	
	

}
