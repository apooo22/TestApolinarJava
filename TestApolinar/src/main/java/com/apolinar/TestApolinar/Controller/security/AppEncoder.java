
package com.apolinar.TestApolinar.Controller.security;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AppEncoder {

	public static void main(String[] args) {
		System.out.println(new BCryptPasswordEncoder().encode("abc")); 

	}

}
