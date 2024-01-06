package com.anudip.training.serviceimpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anudip.training.entity.Bookings;
import com.anudip.training.exception.RecordsNotFoundException;
import com.anudip.training.model.BookingsDTO;
import com.anudip.training.repository.BookingRepository;
import com.anudip.training.service.BookingService;
import com.anudip.training.util.BookingsConvertor;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	BookingRepository brepo;
	
	@Autowired
	BookingsConvertor bconvertor;
	
	@Override
	public BookingsDTO addBookings(Bookings booking) {
		
		brepo.save(booking);
	    return bconvertor.convertToBookingsDTO(booking);
	}

	@Override
	public BookingsDTO viewBookingsDetails(int bookingId) {
		
		Bookings booking = brepo.findById(bookingId)
                .orElseThrow(() -> new RecordsNotFoundException("Bookings with Id '" + bookingId + "'Not Found!"));
        return bconvertor.convertToBookingsDTO(booking);
	}

	@Override
	public BookingsDTO updateBookingsDetails(Bookings booking, int bookingId) {
		
		Bookings updateBookings = brepo.findById(bookingId)
                .orElseThrow(() -> new RecordsNotFoundException("Bookings with Id '" + bookingId + "'Not Found!"));

		updateBookings.setBookingId(booking.getBookingId());
		updateBookings.setCid(booking.getCid());
		updateBookings.setDateOfBooking(booking.getDateOfBooking());
		updateBookings.setNoOfSeats(booking.getNoOfSeats());
		updateBookings.setTotalAmount(booking.getTotalAmount());

        return bconvertor.convertToBookingsDTO(brepo.save(updateBookings));
	}

	@Override
	public void deleteBookingsDetails(int bookingId) {

		brepo.findById(bookingId)
        .orElseThrow(() -> new RecordsNotFoundException("Bookings with Id '" + bookingId + "'Not Found!"));
		brepo.deleteById(bookingId);;
	}

	@Override
	public List<BookingsDTO> findBookingByDate(String dateOfBooking) {
		
		List<Bookings> booking = brepo.findByBookingDateContaining(dateOfBooking);

        if (booking.isEmpty()) {
            throw new RecordsNotFoundException("Bookings with date '" + dateOfBooking + "' Not found!");
        }

        return bconvertor.convertToBookingsDTOList(booking);
	}

	@Override
	public List<BookingsDTO> getAllBookings() {
		
		List<Bookings> booking = brepo.findAll();

        if (booking.isEmpty()) {
            throw new RecordsNotFoundException("Booking Records Not Found!");
        }

        return bconvertor.convertToBookingsDTOList(booking);
	}

	

}
