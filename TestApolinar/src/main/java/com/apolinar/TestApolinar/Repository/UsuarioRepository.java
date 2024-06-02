package com.apolinar.TestApolinar.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

import com.apolinar.TestApolinar.Entity.UsuarioEntity;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	Optional<UsuarioEntity> findByCorreo(String correo);
	// JPQL(Java Persistence Query Language)

	@Query("select p from UsuarioEntity p where p.usuario = :usuario and p.estado='1'")
	Optional<UsuarioEntity> findByUsuario(@Param("usuario") String usuario);
	
}
