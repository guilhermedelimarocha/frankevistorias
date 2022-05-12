package com.frankevistorias.api.usuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
	private final PasswordEncoder encoder;

    @Autowired
	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder encoder) {
		this.usuarioRepository = usuarioRepository;
		this.encoder = encoder;
	}

	public Long save(UsuarioEntity usuarioEntity) throws NotFoundException{

		usuarioEntity.setSenha(encoder.encode(usuarioEntity.getSenha()));
		usuarioEntity = usuarioRepository.save(usuarioEntity);

		return usuarioEntity.getId();
	}

	public  Optional<UsuarioEntity> findByEmail(String email){
		return usuarioRepository.findByEmail(email);
	}

	public void delete(Long id) throws NotFoundException {
		usuarioRepository.findById(id).orElseThrow(() -> new NotFoundException());
		usuarioRepository.deleteById(id);
	}
    
}