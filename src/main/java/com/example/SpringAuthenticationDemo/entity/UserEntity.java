package com.example.SpringAuthenticationDemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class UserEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate ID
    private long id;
	
	@Column(unique = true, nullable =  false)
	private String email;
	private String name;
	private String password;
	@Column(unique = true, nullable =  false)
	private String mobileNumber;
	private String imageUrl;
	
}
