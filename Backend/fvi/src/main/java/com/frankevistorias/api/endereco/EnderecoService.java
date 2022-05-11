package com.frankevistorias.api.endereco;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
	public EnderecoService(EnderecoRepository enderecoRepository) {
		this.enderecoRepository = enderecoRepository;
	}

	public Long save(EnderecoEntity enderecoEntity) throws NotFoundException{

		enderecoEntity = enderecoRepository.save(enderecoEntity);

		return enderecoEntity.getId();
	}

	public List<EnderecoEntity> findAll(){
		return enderecoRepository.findAll();
	}
    
}
