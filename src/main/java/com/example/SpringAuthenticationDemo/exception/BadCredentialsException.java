package com.example.SpringAuthenticationDemo.exception;

public class BadCredentialsException extends RuntimeException {
	
	public BadCredentialsException(String message) {
		super(message);
	}

}
