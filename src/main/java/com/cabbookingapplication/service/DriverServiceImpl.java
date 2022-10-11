package com.cabbookingapplication.service;

import java.util.List;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbookingapplication.dto.DriverDto;
import com.cabbookingapplication.entity.Driver;
import com.cabbookingapplication.repository.DriverRepository;
import com.cabbookingapplication.ui.DriverResponseModel;

@Service
public class DriverServiceImpl implements DriverService{
	
	   private final DriverRepository driverRepository;
	    private final ModelMapper modelMapper;

	    @Autowired
	    public DriverServiceImpl(DriverRepository driverRepository, ModelMapper modelMapper) {
	        this.driverRepository = driverRepository;
	        this.modelMapper = modelMapper;
	    }

	@Override
	public DriverResponseModel createDriver(DriverDto driverDto) {
		
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
	        Driver driver=driverRepository.save(modelMapper.map(driverDto,Driver.class));
	        return modelMapper.map(driver,DriverResponseModel.class);
	}
	

	@Override
	public List<Driver> findAll(int x_cordinate) {
		int userLocation = x_cordinate;
		int from = userLocation-5;
		int to = userLocation+5;
		List<Driver> availableDriverList = driverRepository.findAll();
		
		System.out.println(availableDriverList);
	
		return availableDriverList.stream().filter(driver->driver.getLocation()
				.getX_cordinate()>from && driver.getLocation().getX_cordinate()<to).collect(Collectors.toList());
	}

}
