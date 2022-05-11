package com.frankevistorias.api.imobiliaria;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ImobiliariaService {

    private final ImobiliariaRepository imobiliariaRepository;

    @Autowired
	public ImobiliariaService(ImobiliariaRepository imobiliariaRepository) {
		this.imobiliariaRepository = imobiliariaRepository;
	}

	public Long save(ImobiliariaEntity imobiliariaEntity) throws NotFoundException{

		imobiliariaEntity = imobiliariaRepository.save(imobiliariaEntity);

		return imobiliariaEntity.getId();
	}

	public List<ImobiliariaEntity> findAll(){
		return imobiliariaRepository.findAll();
	}
    
}
