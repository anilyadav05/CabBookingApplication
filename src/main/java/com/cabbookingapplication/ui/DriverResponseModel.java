package com.cabbookingapplication.ui;

import com.cabbookingapplication.dto.LocationDto;
import com.cabbookingapplication.entity.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DriverResponseModel {
	private String driverName;
	private Gender gender;
	private int age;
	private String modelName;
	private String registerationNo;
	private LocationDto locationdto;
}
