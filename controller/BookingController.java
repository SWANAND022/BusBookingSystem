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

import com.anudip.training.entity.Bookings;
import com.anudip.training.model.BookingsDTO;
import com.anudip.training.service.BookingService;
import com.anudip.training.util.BookingsConvertor;

@RestController
@RequestMapping("/Bookings")
public class BookingController {
	
	@Autowired
	BookingService bs;
	
	@Autowired
	BookingsConvertor bconvertor;
	
	@PostMapping("/saveBooking")
	public BookingsDTO saveBooking(@RequestBody BookingsDTO bdto)
	{
		Bookings booking1 = bconvertor.convertToBookingsEntity(bdto);	
		
		return bs.addBookings(booking1);
	}
	
	@GetMapping("/getBookingDetails/{bookingId}")
	public BookingsDTO getBookingDetails(@PathVariable("bookingId") int bookingId)
	{
		return bs.viewBookingsDetails(bookingId);
	}
	
	@PutMapping("/editBookingDetails/{bookingId}")
	public BookingsDTO editBookingDetails(@PathVariable("bookingId")int bookingId,@RequestBody BookingsDTO bdto)
	{
		Bookings booking = bconvertor.convertToBookingsEntity(bdto);
        return bs.updateBookingsDetails(booking, bookingId);
	}

	@DeleteMapping("/deleteBookingDetails/{bookingId}")
	public ResponseEntity<String> deleteBookingDetails(@PathVariable("bookingId") int bookingId)
	{
		bs.deleteBookingsDetails(bookingId);
		return new ResponseEntity<String>("deleted Successfully..",HttpStatus.OK);
	}
	
	@GetMapping("/findBookingByDate/{dateOfBooking}")
    public List<BookingsDTO> findBookingByDate(@PathVariable("dateOfBooking") String dateOfBooking) {
       
		return bs.findBookingByDate(dateOfBooking);
    }
 
    @GetMapping("/getAllBookings")
    public List<BookingsDTO> getAllBookings() {
        
        return bs.getAllBookings();
    }
}
