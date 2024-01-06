package com.anudip.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.anudip.training.entity.Bookings;

public interface BookingRepository extends JpaRepository<Bookings, Integer> {
	
	@Query("SELECT b FROM Bookings b WHERE b.dateOfBooking= :dateOfBooking")
    List<Bookings> findByBookingDateContaining(String dateOfBooking);

}
