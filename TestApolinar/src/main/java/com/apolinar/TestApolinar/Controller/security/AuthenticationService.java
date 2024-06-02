package com.apolinar.TestApolinar.Controller.security;

public interface AuthenticationService {

	JwtAuthenticationDTOResponse signin(LoginDTORequest request);
}
