package com.cabbookingapplication.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserNoFoundException extends RuntimeException{
	private static final long serialVersionUID = 2L;
	private String message;
}
