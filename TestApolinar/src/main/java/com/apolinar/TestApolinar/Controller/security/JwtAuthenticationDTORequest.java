package com.apolinar.TestApolinar.Controller.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationDTORequest {
	private String userName;
	private String password;
	//private String name;
	//private String [] roles;
}