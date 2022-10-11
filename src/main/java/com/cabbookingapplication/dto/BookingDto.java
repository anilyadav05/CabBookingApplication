package com.cabbookingapplication.dto;

import com.cabbookingapplication.entity.Location;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookingDto {
	private String userName;
	private Location source;
	private Location destination;
}
