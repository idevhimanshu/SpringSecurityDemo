package com.example.SpringAuthenticationDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringAuthenticationDemo.dto.LoginRequestDTO;
import com.example.SpringAuthenticationDemo.dto.SignUpRequestDTO;
import com.example.SpringAuthenticationDemo.dto.SignUpResponseDTO;
import com.example.SpringAuthenticationDemo.entity.UserEntity;
import com.example.SpringAuthenticationDemo.service.UserService;

import jakarta.validation.Valid;

@RestController
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/signup")
	public ResponseEntity<SignUpResponseDTO> register(@Valid @RequestBody SignUpRequestDTO signUpRequestDTO) {
		return new ResponseEntity<SignUpResponseDTO>( userService.register(signUpRequestDTO), HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<SignUpResponseDTO> register(@RequestBody LoginRequestDTO loginRequestDTO) {
		return new ResponseEntity<SignUpResponseDTO>( userService.login(loginRequestDTO), HttpStatus.OK);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<UserEntity>> getAllUserList() {
		return new ResponseEntity<List<UserEntity>>(userService.getAllUserList(), HttpStatus.OK);
	}

}
