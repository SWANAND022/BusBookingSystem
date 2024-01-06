package com.anudip.training.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.entity.Bus;
import com.anudip.training.model.BusDTO;

@Component
public class BusConvertor {
	
	//converting Bus Entity to Bus DTO
	
		public BusDTO convertToBusDTO(Bus bus){
			
			BusDTO bdto = new BusDTO();
			if(bus != null)
			{
				//copy data from Bus to BusDTO
				BeanUtils.copyProperties(bus, bdto);
				
			}
			return bdto;
		}
		
		//converting Bus dto to Bus entity
		public Bus convertToBusEntity(BusDTO bdto){
				
				Bus bus = new Bus();
				if(bdto != null)
				{
					//copy data from Bus to BusDTO
					BeanUtils.copyProperties(bdto, bus);
					
				}
				return bus;
			}
		
		 // converting List of Bus Entities to List of BusDTOs
	    public List<BusDTO> convertToBusDTOList(List<Bus> buses) {
	        return buses.stream()
	                .map(this::convertToBusDTO)
	                .collect(Collectors.toList());
	    }


}
