package com.apolinar.TestApolinar.UsuarioService;

import java.util.List;
import java.util.Optional;


public interface GenericFechasService<T> {
	

	List<T> findLikeObject(T t) throws ServiceException;
	
	T save(T t) throws ServiceException;
	
	T update(T t) throws ServiceException;
	
}
