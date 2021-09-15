package com.dg.gestao.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncoderPassword {
	
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public static String encode(String password) {		
		return encoder.encode(password);
	}
	
	public static boolean isPasswordValido(String password, String passwordEncoder) {		
		return encoder.matches(password, passwordEncoder);
	}
}
