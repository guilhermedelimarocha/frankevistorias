package com.frankevistorias.api.uriAssets;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AssetsService {

    private final AssetsRepository assetsRepository;

    @Autowired
	public AssetsService(AssetsRepository assetsRepository) {
		this.assetsRepository = assetsRepository;
	}

	public Long save(AssetsEntity assetsEntity) throws NotFoundException{

		assetsEntity = assetsRepository.save(assetsEntity);

		return assetsEntity.getId();
	}

	public List<AssetsEntity> findAll(){
		return assetsRepository.findAll();
	}
    
}
