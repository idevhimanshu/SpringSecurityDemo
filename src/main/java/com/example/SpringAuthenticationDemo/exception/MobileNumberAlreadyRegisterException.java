package com.example.SpringAuthenticationDemo.exception;

public class MobileNumberAlreadyRegisterException extends RuntimeException {
	
	public MobileNumberAlreadyRegisterException(String message) {
		super(message);
	}
}
