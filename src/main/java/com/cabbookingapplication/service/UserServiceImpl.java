package com.cabbookingapplication.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabbookingapplication.dto.UserDto;
import com.cabbookingapplication.entity.User;
import com.cabbookingapplication.repository.UserRepository;
import com.cabbookingapplication.ui.UserResponseModel;

@Service
public class UserServiceImpl implements UserService {
	
	   private final UserRepository userRepository;
	    private final ModelMapper modelMapper;

	    @Autowired
	    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
	        this.userRepository = userRepository;
	        this.modelMapper = modelMapper;
	    }

	@Override
	public UserResponseModel createUser(UserDto userDto) {
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	        User user=userRepository.save(modelMapper.map(userDto,User.class));
	        return modelMapper.map(user,UserResponseModel.class);
	}

}
