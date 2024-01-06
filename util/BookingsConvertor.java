package com.anudip.training.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.anudip.training.entity.Bookings;
import com.anudip.training.model.BookingsDTO;

@Component
public class BookingsConvertor {
	
	//converting Bookings Entity to Bookings DTO
	
	public BookingsDTO convertToBookingsDTO(Bookings bookings){
		
		BookingsDTO bdto = new BookingsDTO();
		if(bookings != null)
		{
			//copy data from Bookings to BookingsDTO
			BeanUtils.copyProperties(bookings, bdto);
			
		}
		return bdto;
	}
	
	//converting Bookings dto to Bookings entity
	public Bookings convertToBookingsEntity(BookingsDTO bdto){
			
			Bookings bookings = new Bookings();
			if(bdto != null)
			{
				//copy data from Bookings to BookingsDTO
				BeanUtils.copyProperties(bdto, bookings);
				
			}
			return bookings;
		}
	
	 // converting List of Bookings Entities to List of BookingsDTOs
    public List<BookingsDTO> convertToBookingsDTOList(List<Bookings> bookings) {
        return bookings.stream()
                .map(this::convertToBookingsDTO)
                .collect(Collectors.toList());
    }

	
	

}
