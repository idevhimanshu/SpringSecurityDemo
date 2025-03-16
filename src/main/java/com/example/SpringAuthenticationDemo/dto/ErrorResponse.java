package com.example.SpringAuthenticationDemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {
	
	private boolean status;
    private String message;

    public ErrorResponse(String message, boolean status)
    {
        super();
        this.message = message;
        this.status = status;
    }

}
