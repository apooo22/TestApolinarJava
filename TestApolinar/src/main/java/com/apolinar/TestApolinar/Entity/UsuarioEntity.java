package com.apolinar.TestApolinar.Entity;



import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;



@Entity(name ="UsuarioEntity" )
@Table(name = "TBL_USUARIO")


@Data
public class UsuarioEntity {
	
	   @GeneratedValue(strategy = GenerationType.AUTO)
	   @Column(name = "ID")
	   
	   @Id
	   private Long id;
	   
	   @Column(name = "NOMBRE")
	   private String nombre;
	   
	   @Column(name = "USUARIO")
	   private String usuario;
	   
	   @Email(message = "El correo debe venir en formato: correo@dominio.cl", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	   @NotEmpty(message = "Email cannot be empty")
	   	   
	   @Column(name = "CORREO")
	   private String correo;
	   
	   @Column(name = "CLAVE")
	   private String clave;
	   
	   @Column(name = "TELEFONO")
	   private String telefono;
	   
	   @Column(name = "ESTADO")
	   private String estado;
	   
	   @Column(name = "CODIGO_CIUDAD")
	   private String codigoCiudad;
	   
	   @Column(name = "CODIGO_PAIS")
	   private String codigoPais;
	   
		
		@Column(name = "FECHA_CREACION")
		 private Date fechaCreacion; 
		
		 
		@Column(name = "FECHA_ULTIMA_ACTUALIZACION")
		private LocalDateTime fechaUltimaActualizacion = LocalDateTime.now();
		
		@Column(name = "FECHA_ULTIMO_INGRESO")
		private LocalDateTime fechaUltimoIngreso = LocalDateTime.now();
	   


}
