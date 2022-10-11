package com.cabbookingapplication.ui;

import com.cabbookingapplication.entity.Gender;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserRequestModel {
	private String name;
	private Gender gender;
	private int age;
}
