package com.example.SpringAuthenticationDemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.SpringAuthenticationDemo.dto.LoginRequestDTO;
import com.example.SpringAuthenticationDemo.dto.SignUpRequestDTO;
import com.example.SpringAuthenticationDemo.dto.SignUpResponseDTO;
import com.example.SpringAuthenticationDemo.entity.UserEntity;

@Service
public interface UserService {
	SignUpResponseDTO register(SignUpRequestDTO signUpRequestDTO);
	SignUpResponseDTO login(LoginRequestDTO loginRequestDTO);
	List<UserEntity> getAllUserList();

}
