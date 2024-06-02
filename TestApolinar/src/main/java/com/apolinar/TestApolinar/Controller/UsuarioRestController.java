package com.apolinar.TestApolinar.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apolinar.TestApolinar.Entity.UsuarioEntity;
import com.apolinar.TestApolinar.Repository.UsuarioRepository;
import com.apolinar.TestApolinar.UsuarioService.ServiceException;
import com.apolinar.TestApolinar.UsuarioService.UsuarioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/Usuarios")
public class UsuarioRestController {

	private final UsuarioService UsuarioService;

	public UsuarioRestController(UsuarioService UsuarioService) {
		this.UsuarioService = UsuarioService;
	}

	@GetMapping
	public ResponseEntity<List<UsuarioEntity>> findAll() {
		try {
			UsuarioEntity prmUsuarioEntity = new UsuarioEntity();
			prmUsuarioEntity.setNombre("");
			List<UsuarioEntity> lstUsuarioEntity = UsuarioService.findLikeObject(prmUsuarioEntity);
			if (lstUsuarioEntity.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstUsuarioEntity);
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioEntity> findById(@PathVariable("id") Long id) {
		try {
			UsuarioEntity prmUsuarioEntity = new UsuarioEntity();
			prmUsuarioEntity.setId(id);
			Optional<UsuarioEntity> optUsuarioEntity = UsuarioService.findById(prmUsuarioEntity);
			if (optUsuarioEntity.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(optUsuarioEntity.get());
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/by-nombre")
	public ResponseEntity<List<UsuarioEntity>> findByLikeRazonSocial(
			@RequestParam(value = "nombre", defaultValue = "") String nombre) {
		try {
			UsuarioEntity prmUsuarioEntity = new UsuarioEntity();
			prmUsuarioEntity.setNombre(nombre);
			List<UsuarioEntity> lstUsuarioEntity = UsuarioService.findLikeObject(prmUsuarioEntity);
			if (lstUsuarioEntity.isEmpty()) {
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.ok(lstUsuarioEntity);
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@Autowired
	private UsuarioRepository repository;

	@PostMapping("/post")
	public ResponseEntity<?> save(@RequestBody UsuarioEntity usuarioEntity) {
		try {

			Optional<UsuarioEntity> existingEntity = repository.findByCorreo(usuarioEntity.getCorreo());
			if (existingEntity.isPresent()) {
				
               Map<String,String>mensage=new HashMap();            	   
               mensage.put("mensage", "El correo ya esta Registrado");
				return ResponseEntity.badRequest().body(mensage);
	
				
			} else {
				UsuarioEntity rUsuarioEntity = UsuarioService.save(usuarioEntity);
				if (rUsuarioEntity == null) {
					return ResponseEntity.badRequest().build();
				} else {
					return ResponseEntity.status(HttpStatus.CREATED).body(rUsuarioEntity);
				}
			}

		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<UsuarioEntity> update(@PathVariable("id") Long id, @RequestBody UsuarioEntity UsuarioEntity) {
		try {
			UsuarioEntity.setId(id);
			UsuarioEntity rUsuarioEntity = UsuarioService.update(UsuarioEntity);
			if (rUsuarioEntity == null) {
				return ResponseEntity.badRequest().build();
			}
			return ResponseEntity.ok(rUsuarioEntity);
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
		try {
			UsuarioEntity prmUsuarioEntity = new UsuarioEntity();
			prmUsuarioEntity.setId(id);
			UsuarioService.delete(prmUsuarioEntity);
			return ResponseEntity.ok().build();
		} catch (ServiceException e) {
			return ResponseEntity.internalServerError().build();
		}
	}

}
