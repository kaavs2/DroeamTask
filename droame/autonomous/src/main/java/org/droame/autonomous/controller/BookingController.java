package org.droame.autonomous.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import  org.droame.autonomous.exception.ResourceNotFoundException;
import org.droame.autonomous.model.Booking;
import org.droame.autonomous.repository.BookingRepository;

@RestController 
@CrossOrigin(origins = "http://localhost:3306")
@RequestMapping("/booking")

public class BookingController {
	
	@Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/getBookingList")
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @GetMapping("/getBooking/{booking_id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable(value = "booking_id") Long bookingId)
        throws ResourceNotFoundException {
    	Booking booking = bookingRepository.findById(bookingId)
          .orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + bookingId));
        return ResponseEntity.ok().body(booking);
    }
    
    @PostMapping("/addBooking")
    public Booking createBooking(@Valid @RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    @PutMapping("/updateBooking/{booking_id}")
    public ResponseEntity<Booking> updatebooking(@PathVariable(value = "booking_id") Long bookingId,
         @Valid @RequestBody Booking bookingDetails) throws ResourceNotFoundException {
    	Booking booking = bookingRepository.findById(bookingId)
        .orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + bookingId));

    	booking.setCreatedTime(bookingDetails.getCreatedTime());
    	booking.setDroneShotName(bookingDetails.getDroneShotName());
    	booking.setCustomerId(bookingDetails.getCustomerId());
        final Booking updatedBooking = bookingRepository.save(booking);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/deleteBooking/{booking_id}")
    public Map<String, Boolean> deleteBooking(@PathVariable(value = "booking_id") Long bookingId)
         throws ResourceNotFoundException {
    	Booking booking = bookingRepository.findById(bookingId)
       .orElseThrow(() -> new ResourceNotFoundException("Booking not found for this id :: " + bookingId));

    	bookingRepository.delete(booking);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
