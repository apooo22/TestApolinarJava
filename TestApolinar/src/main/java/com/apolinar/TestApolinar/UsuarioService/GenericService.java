package com.apolinar.TestApolinar.UsuarioService;

import java.util.List;
import java.util.Optional;


public interface GenericService<T> {
	
	Optional<T> findById(T t) throws ServiceException;

	List<T> findLikeObject(T t) throws ServiceException;
	
	T save(T t) throws ServiceException;
	
	T update(T t) throws ServiceException;
	
	Boolean delete(T t) throws ServiceException;

}
