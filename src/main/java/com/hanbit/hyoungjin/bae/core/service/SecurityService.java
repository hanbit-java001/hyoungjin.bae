package com.hanbit.hyoungjin.bae.core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityService.class);

	private static PasswordEncoder encoder = new StandardPasswordEncoder();

	public String encryptPassword(String password){
		return encoder.encode(password);
	}

	public boolean matchPassword(String rawPassword, String encryptedPaaword){
		return encoder.matches(rawPassword, encryptedPaaword);
	}
}
