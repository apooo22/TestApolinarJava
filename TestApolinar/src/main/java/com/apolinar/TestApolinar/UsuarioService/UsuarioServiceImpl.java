package com.apolinar.TestApolinar.UsuarioService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apolinar.TestApolinar.Entity.UsuarioEntity;
import com.apolinar.TestApolinar.Repository.*;




@Service
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository UsuarioRepository;
	
	public UsuarioServiceImpl(UsuarioRepository UsuarioRepository) {
	this.UsuarioRepository=UsuarioRepository;
	}

	@Override
	public Optional<UsuarioEntity> findById(UsuarioEntity UsuarioEntity) throws ServiceException {
		try {
			return UsuarioRepository.findById(UsuarioEntity.getId());
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	
	public UsuarioEntity save(UsuarioEntity UsuarioEntity) throws ServiceException {
		try {
			return UsuarioRepository.save(UsuarioEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public UsuarioEntity update(UsuarioEntity UsuarioEntity) throws ServiceException {
		try {
			//Verificar si  existe
			Optional<UsuarioEntity> rUsuarioEntity = UsuarioRepository.findById(UsuarioEntity.getId());
			if (rUsuarioEntity.isPresent()) {
				UsuarioEntity prmUsuarioEntity = rUsuarioEntity.get();
				BeanUtils.copyProperties(UsuarioEntity, prmUsuarioEntity);
				return UsuarioRepository.save(prmUsuarioEntity);
			}
			return UsuarioRepository.save(UsuarioEntity);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Boolean delete(UsuarioEntity t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioEntity> findLikeObject(UsuarioEntity t) throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	
    @Autowired
    private UsuarioRepository repository;

    public UsuarioEntity saveIfNotExists(UsuarioEntity entity) {
        Optional<UsuarioEntity> existingEntity = repository.findByCorreo(entity.getCorreo());
        if (existingEntity.isPresent()) {
            throw new RuntimeException("El correo ya esta Registrado");
        } else {
            return repository.save(entity);
        }
    }
}
	



	
		

