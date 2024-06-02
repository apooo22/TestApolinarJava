package com.apolinar.TestApolinar.Controller.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

	String extractUser(String token);

	String generateToken(UserDetails userDetails);

	boolean isTokenValid(String token, UserDetails userDetails);
}
