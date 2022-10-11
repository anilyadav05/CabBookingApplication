package com.cabbookingapplication.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cabbookingapplication.ui.ErrorResponseModel;

@RestControllerAdvice
public class ControllerExceptionHandler {
	  @ExceptionHandler
	    public ResponseEntity<ErrorResponseModel> handleNoRideFoundException(NoRideFoundException e)
	    {
	        ErrorResponseModel errorResponseModel=new ErrorResponseModel();
	        errorResponseModel.setMessage(e.getMessage());
	        errorResponseModel.setStatusCode(HttpStatus.NOT_FOUND.value());
	        errorResponseModel.setErrorReportingTime(System.currentTimeMillis());
	        return ResponseEntity.status(errorResponseModel.getStatusCode()).body(errorResponseModel);
	    }
	  
	  @ExceptionHandler
	    public ResponseEntity<ErrorResponseModel> handleUserNoFoundException(UserNoFoundException e)
	    {
	        ErrorResponseModel errorResponseModel=new ErrorResponseModel();
	        errorResponseModel.setMessage(e.getMessage());
	        errorResponseModel.setStatusCode(HttpStatus.NOT_FOUND.value());
	        errorResponseModel.setErrorReportingTime(System.currentTimeMillis());
	        return ResponseEntity.status(errorResponseModel.getStatusCode()).body(errorResponseModel);
	    }
}
