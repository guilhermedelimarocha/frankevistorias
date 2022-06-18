package com.frankevistorias.api.uriAssets;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frankevistorias.api.atendimento.AtendimentoEntity;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Repository
public interface AssetsRepository extends JpaRepository<AssetsEntity, Long>{
/*
	Optional<AssetsEntity> findIdUsuario(Long idUsuario);
*/
	
}
