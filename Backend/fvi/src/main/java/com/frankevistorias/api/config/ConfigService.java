package com.frankevistorias.api.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ConfigService {

    private final ConfigRepository configRepository;

    @Autowired
	public ConfigService(ConfigRepository configRepository) {
		this.configRepository = configRepository;
	}

	public Long save(ConfigEntity configEntity) throws NotFoundException{

		configEntity = configRepository.save(configEntity);

		return configEntity.getId();
	}

	public List<ConfigEntity> findAll(){
		return configRepository.findAll();
	}
    
}
