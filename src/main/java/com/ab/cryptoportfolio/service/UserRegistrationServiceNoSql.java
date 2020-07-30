package com.ab.cryptoportfolio.service;

import java.util.ArrayList;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ab.cryptoportfolio.entity.CryptoUser;
import com.ab.cryptoportfolio.entity.Portfolio;
import com.ab.cryptoportfolio.model.UserDto;
import com.ab.cryptoportfolio.repository.PortfolioRepository;
import com.ab.cryptoportfolio.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserRegistrationServiceNoSql implements UserRegistrationService{
	
	private final UserRepository userRepository;
	private final PortfolioRepository portfolioRepository;
	private final PasswordEncoder encoder;
	
	@Override
	public void createUser(UserDto user) {
		CryptoUser cryptUser = new CryptoUser(user.getUsername(), 
											  user.getFirstname(), 
											  user.getLastname(),
											  user.getEmail(), 
											  encoder.encode(user.getPassword()));
		userRepository.save(cryptUser);
		portfolioRepository.save(new Portfolio(user.getUsername(), new ArrayList<>()));		
	}

}