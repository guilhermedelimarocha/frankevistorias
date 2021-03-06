package com.frankevistorias.api.endereco;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

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
	public List<EnderecoEntity> findByCep(String cep){
		return enderecoRepository.findByCep(cep);
	}
	
	public Optional<EnderecoEntity> findById(Long id){
		return enderecoRepository.findById(id);
	}
	
	public List<EnderecoEntity> findAll(){
		return enderecoRepository.findAll();
	}
	public void delete(Long id) throws NotFoundException {
		enderecoRepository.findById(id).orElseThrow(() -> new NotFoundException());
		enderecoRepository.deleteById(id);
	}
    
}
