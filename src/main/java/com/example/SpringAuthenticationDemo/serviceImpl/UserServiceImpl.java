package com.example.SpringAuthenticationDemo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringAuthenticationDemo.dto.LoginRequestDTO;
import com.example.SpringAuthenticationDemo.dto.SignUpRequestDTO;
import com.example.SpringAuthenticationDemo.dto.SignUpResponseDTO;
import com.example.SpringAuthenticationDemo.entity.UserEntity;
import com.example.SpringAuthenticationDemo.exception.BadCredentialsException;
import com.example.SpringAuthenticationDemo.exception.MobileNumberAlreadyRegisterException;
import com.example.SpringAuthenticationDemo.exception.UserAlreadyRegisterException;
import com.example.SpringAuthenticationDemo.repository.UserRepository;
import com.example.SpringAuthenticationDemo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired 
	private ModelMapper mapper;

	@Override
	public SignUpResponseDTO register(SignUpRequestDTO signUpRequestDTO) {
		if (userRepository.existsByEmail(signUpRequestDTO.getEmail())) {
			throw new UserAlreadyRegisterException("Email alredy register with another user");
		}
		if (userRepository.existsByMobileNumber(signUpRequestDTO.getMobileNumber())) {
			throw new MobileNumberAlreadyRegisterException("Mobile number already register with another user");
		}
		UserEntity userEntity = mapper.map(signUpRequestDTO, UserEntity.class);
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		UserEntity savedUserEntity = this.userRepository.save(userEntity);
		return mapper.map(savedUserEntity, SignUpResponseDTO.class);
	}

	@Override
	public SignUpResponseDTO login(LoginRequestDTO loginRequestDTO) {
		Optional<UserEntity> optionalUser = this.userRepository.findByEmail(loginRequestDTO.getEmail());
		if (optionalUser.isEmpty()) {
	        throw new UsernameNotFoundException("User is not registered. Please sign up first.");
	    }
		UserEntity userEntity = optionalUser.get();
	    if (!passwordEncoder.matches(loginRequestDTO.getPassword(), userEntity.getPassword())) {
	        throw new BadCredentialsException("Invalid email or password.");
	    }

	    // Convert the user entity to response DTO
	    return mapper.map(userEntity, SignUpResponseDTO.class);

	}

	@Override
	public List<UserEntity> getAllUserList() {
		return this.userRepository.findAll();
	}
	

}
