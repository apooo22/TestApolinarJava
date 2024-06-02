package com.apolinar.TestApolinar.CorreoYaRegistradoException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

	

	    @ExceptionHandler(CorreoYaRegistradoException.class)
	    public ResponseEntity<String> handleCorreoYaRegistradoException(CorreoYaRegistradoException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	}

