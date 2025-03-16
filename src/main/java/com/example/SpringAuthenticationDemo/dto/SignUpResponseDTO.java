package com.example.SpringAuthenticationDemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SignUpResponseDTO {
	
	private long id;
	private String email;
	private String name;
	private String password;
	private String mobileNumber;
	private String imageUrl;

}
