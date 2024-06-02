package com.apolinar.TestApolinar.UsuarioService;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.apolinar.TestApolinar.Entity.UsuarioEntity;
import com.apolinar.TestApolinar.Repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	private final UsuarioRepository usuarioRepository;
	
	public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UsuarioEntity usuarioEntity= usuarioRepository.findByUsuario(username)
				.orElseThrow(()-> new UsernameNotFoundException("El usuairo no existe"));
		return User
				.builder()
				.username(usuarioEntity.getUsuario())
				.password(usuarioEntity.getClave())
				.authorities(Collections.emptyList())
				.build();
	}

}
