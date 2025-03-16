package com.example.SpringAuthenticationDemo.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAlreadyRegisterException extends RuntimeException {
	
	public UserAlreadyRegisterException(String message) {
		super(message);
	}

}
