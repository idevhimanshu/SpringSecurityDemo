package com.example.SpringAuthenticationDemo.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.example.SpringAuthenticationDemo.entity.UserEntity;
import com.example.SpringAuthenticationDemo.repository.UserRepository;

@Configuration
public class AppConfiguration {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(customizer -> customizer.disable()).
                authorizeHttpRequests(request -> request
                        .requestMatchers("login", "/signup").permitAll()
                        .anyRequest().authenticated()).
                httpBasic(Customizer.withDefaults()).
                sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
		
	}
	
	@Bean
    public AuthenticationManager authenticationManager(UserDetailsService userDetailsService) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(authProvider);
    }

	@Bean
	public UserDetailsService userDetailsService(UserRepository userRepository) {
	    return new UserDetailsService() {
	        @Override
	        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	            // Find user by email
	            UserEntity user = userRepository.findByEmail(email)
	                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));

	            // Convert UserEntity to Spring Security UserDetails
	            return User.withUsername(user.getEmail())
	                    .password(user.getPassword())
	                    .roles("USER")
	                    .build();
	        }
	    };
	}


    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder(15);
    }
}
