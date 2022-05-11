package com.frankevistorias.api.atendimento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Service
public class AtendimentoService {

    private final AtendimentoRepository atendimentoRepository;

    @Autowired
	public AtendimentoService(AtendimentoRepository atendimentoRepository) {
		this.atendimentoRepository = atendimentoRepository;
	}

	public Long save(AtendimentoEntity atendimentoEntity) throws NotFoundException{

		atendimentoEntity = atendimentoRepository.save(atendimentoEntity);

		return atendimentoEntity.getId();
	}

	public List<AtendimentoEntity> findAll(){
		return atendimentoRepository.findAll();
	}
    
}