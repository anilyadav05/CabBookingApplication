package com.cabbookingapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabbookingapplication.dto.BookingDto;
import com.cabbookingapplication.service.BookingService;

@RestController
public class BookingController {

	@Autowired
	BookingService bookingService;
	
	@PostMapping("/book")
	public ResponseEntity<BookingDto>createBooking(@RequestBody BookingDto bookingDto) {
		BookingDto bookingDto1 = bookingService.createBooking(bookingDto);
		return ResponseEntity.status(HttpStatus.OK).body(bookingDto1);
	}

}
