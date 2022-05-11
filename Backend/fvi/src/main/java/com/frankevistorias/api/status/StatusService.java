package com.frankevistorias.api.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    private final StatusRepository statusRepository;

    @Autowired
	public StatusService(StatusRepository statusRepository) {
		this.statusRepository = statusRepository;
	}

	public Long save(StatusEntity statusEntity) throws NotFoundException{

		statusEntity = statusRepository.save(statusEntity);

		return statusEntity.getId();
	}

	public List<StatusEntity> findAll(){
		return statusRepository.findAll();
	}
    
}