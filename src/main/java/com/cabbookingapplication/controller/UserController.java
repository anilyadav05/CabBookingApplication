package com.cabbookingapplication.controller;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cabbookingapplication.dto.UserDto;
import com.cabbookingapplication.service.UserService;
import com.cabbookingapplication.ui.UserRequestModel;
import com.cabbookingapplication.ui.UserResponseModel;

@RestController
public class UserController {
	private final UserService userService;
    private final ModelMapper modelMapper;
 

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
       
    }

    @PostMapping("/add_user")
    public ResponseEntity<UserResponseModel> createUser(@Validated @RequestBody UserRequestModel userDetails)
    {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UserDto userDto=modelMapper.map(userDetails,UserDto.class);
        UserResponseModel userResponseModel=userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseModel);

    }
}
