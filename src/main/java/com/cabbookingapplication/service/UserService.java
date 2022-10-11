package com.cabbookingapplication.service;

import com.cabbookingapplication.dto.UserDto;
import com.cabbookingapplication.ui.UserResponseModel;

public interface UserService {
	public UserResponseModel createUser(UserDto userDto);
}
