package com.example.SpringAuthenticationDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.SpringAuthenticationDemo.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserAlreadyRegisterException.class)
	public ResponseEntity<ErrorResponse> userAlreadyRegisterExceptionHandling(UserAlreadyRegisterException exception){
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getMessage(), false), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(MobileNumberAlreadyRegisterException.class)
	public ResponseEntity<ErrorResponse> mobileNumberAlreadyRegisterExceptionHandling(MobileNumberAlreadyRegisterException exception){
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getMessage(), false), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<ErrorResponse> usernameNotFoundExceptionHandling(UsernameNotFoundException exception){
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getMessage(), false), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadCredentialsException.class)
	public ResponseEntity<ErrorResponse> badCredentialsExceptionHandler(BadCredentialsException exception){
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getMessage(), false), HttpStatus.UNAUTHORIZED);
	}
	
}
