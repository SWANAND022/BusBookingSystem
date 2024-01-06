package com.anudip.training.service;

import java.util.List;

import com.anudip.training.entity.Bookings;
import com.anudip.training.model.BookingsDTO;

public interface BookingService {
	
		//For adding new Booking Details/records
		BookingsDTO addBookings(Bookings booking);
		
		//For getting Booking details/records
		BookingsDTO viewBookingsDetails(int bookingId);
		
		//For update Booking details/records
		BookingsDTO updateBookingsDetails(Bookings booking, int bookingId);
		
		//For deleting existing Booking details/records
		void deleteBookingsDetails(int bookingId);
		
		//For getting booking by date
		List<BookingsDTO> findBookingByDate(String dateOfBooking);
		
		//For getting all bookings List
		List<BookingsDTO> getAllBookings();

}
