package com.anudip.training.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.entity.Driver;
import com.anudip.training.model.DriverDTO;

@Component
public class DriverConvertor {
	
	//converting Driver Entity to Driver DTO
	
			public DriverDTO convertToDriverDTO(Driver driver){
				
				DriverDTO ddto = new DriverDTO();
				if(driver != null)
				{
					//copy data from Driver to DriverDTO
					BeanUtils.copyProperties(driver, ddto);
					
				}
				return ddto;
			}
			
			//converting Driver dto to Driver entity
			public Driver convertToDriverEntity(DriverDTO ddto){
					
					Driver driver = new Driver();
					if(ddto != null)
					{
						//copy data from Driver to DriverDTO
						BeanUtils.copyProperties(ddto, driver);
						
					}
					return driver;
				}
			
			 // converting List of Driver Entities to List of DriverDTOs
		    public List<DriverDTO> convertToDriverDTOList(List<Driver> driveres) {
		        return driveres.stream()
		                .map(this::convertToDriverDTO)
		                .collect(Collectors.toList());
		    }

}
