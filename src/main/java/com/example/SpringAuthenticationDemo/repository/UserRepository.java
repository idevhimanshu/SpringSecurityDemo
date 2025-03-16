package com.example.SpringAuthenticationDemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringAuthenticationDemo.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	 // Find user by email (returns Optional to avoid null pointer issues)
    Optional<UserEntity> findByEmail(String email);
    
    // Check if an email already exists
    boolean existsByEmail(String email);
    
    // Check if a mobile number already exists
    boolean existsByMobileNumber(String mobileNumber);
}
