package com.cabbookingapplication.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbookingapplication.controller.DriverController;
import com.cabbookingapplication.dto.BookingDto;
import com.cabbookingapplication.entity.Booking;
import com.cabbookingapplication.entity.Driver;
import com.cabbookingapplication.exception.UserNoFoundException;
import com.cabbookingapplication.repository.BookingRepository;
import com.cabbookingapplication.repository.DriverRepository;
import com.cabbookingapplication.repository.UserRepository;

@Service
public class BookingServiceImpl implements BookingService {
	
	BookingRepository bookingRepository;
	
	DriverRepository driverRepository;
	
	UserRepository userRepository;
	
	ModelMapper modelMapper;
	
	@Autowired
	public BookingServiceImpl(BookingRepository bookingRepository,DriverRepository driverRepository,ModelMapper modelMapper,UserRepository userRepository) {
		this.bookingRepository=bookingRepository;
		this.driverRepository=driverRepository;
		this.userRepository = userRepository;
		this.modelMapper=modelMapper;
	}

	@Override
	public BookingDto createBooking(BookingDto bookingDto) {
		//checking if the username exists
		if(userRepository.findAll().stream().map(u->u.getName()).collect(Collectors.toList()).contains(bookingDto.getUserName())){
			//assigning one from available drivers
			int sourceLocation = bookingDto.getSource().getX_cordinate();
			int from = Math.abs(sourceLocation-5);
			int to = sourceLocation+5;
			List<Driver> driverList = driverRepository.findAll();
			List<Driver> availableDriverList = driverList.stream().filter(driver->driver.getLocation()
		
					.getX_cordinate()>from && driver.getLocation().getX_cordinate()<to).collect(Collectors.toList());
			Random randomizer = new Random();
			Driver driver = availableDriverList.get(randomizer.nextInt(availableDriverList.size()));
		Booking booking  = new Booking();
		booking.setDriverName(driver.getDriverName());
		booking.setRegisterationNo(driver.getVehicle().getRegisterationNo());
		booking.setUserName(bookingDto.getUserName());
		booking.setSource(bookingDto.getSource());
		booking.setDestination(bookingDto.getDestination());
		bookingRepository.save(booking);
		return bookingDto;
		}else {
			throw new UserNoFoundException("username with "+bookingDto.getUserName()+" does not exist");
		}
		
	}

}
