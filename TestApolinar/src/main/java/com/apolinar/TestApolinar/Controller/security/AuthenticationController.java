package com.apolinar.TestApolinar.Controller.security;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	private final AuthenticationService authenticationService;

	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationDTOResponse> signin(@RequestBody LoginDTORequest request) {
		log.info("signin ...");
		return ResponseEntity.ok(authenticationService.signin(request));
	}

	
}