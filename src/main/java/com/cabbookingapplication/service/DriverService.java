package com.cabbookingapplication.service;

import java.util.List;


import com.cabbookingapplication.dto.DriverDto;
import com.cabbookingapplication.entity.Driver;
import com.cabbookingapplication.ui.DriverResponseModel;

public interface DriverService {
	public DriverResponseModel createDriver(DriverDto driverDto);
 
	public List<Driver> findAll(int x_cordinate);
}
