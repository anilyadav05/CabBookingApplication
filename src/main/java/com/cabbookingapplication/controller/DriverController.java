package com.cabbookingapplication.controller;

import java.util.List;


import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabbookingapplication.dto.DriverDto;
import com.cabbookingapplication.entity.Driver;
import com.cabbookingapplication.exception.NoRideFoundException;
import com.cabbookingapplication.service.DriverService;
import com.cabbookingapplication.ui.DriverRequestModel;
import com.cabbookingapplication.ui.DriverResponseModel;

@RestController
public class DriverController {
	private final DriverService driverService;
    private final ModelMapper modelMapper;
 

    @Autowired
    public DriverController(DriverService driverService, ModelMapper modelMapper) {
        this.driverService = driverService;
        this.modelMapper = modelMapper;
       
    }
    
    @PostMapping("/add_driver")
    public ResponseEntity<DriverResponseModel> createDriver(@Validated @RequestBody DriverRequestModel driverDetails)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        DriverDto driverDto=modelMapper.map(driverDetails,DriverDto.class);
        DriverResponseModel driverResponseModel=driverService.createDriver(driverDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(driverResponseModel);

    }
    
	@GetMapping("/find_ride/{x_cordinate}")
	public ResponseEntity<List<Driver>> findAllDriversByAvailablity(@PathVariable int x_cordinate){
		List<Driver> driverList = driverService.findAll(x_cordinate);
		System.out.println(driverList);
		if(driverList.size()==0) {
			throw new NoRideFoundException("No ride found");
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(driverList);
	}
}
