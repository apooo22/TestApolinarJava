package com.apolinar.TestApolinar.Controller.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

	private final UserDetailsService userDetailsService;
	
	private final JwtService jwtService;
	
	private final AuthenticationManager authenticationManager;

	@Override
	public JwtAuthenticationDTOResponse signin(LoginDTORequest request) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsuario(), request.getClave()));
		UserDetails userDetails= userDetailsService.loadUserByUsername(request.getUsuario());
		if (isNull(userDetails)) {
			throw new IllegalArgumentException("Usuario o clave no validad!");
		}
		String jwt = jwtService.generateToken(userDetails);
		
		return JwtAuthenticationDTOResponse.builder().token(jwt).build();
	}
}