package com.frankevistorias.api.endereco;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.frankevistorias.api.atendimento.AtendimentoEntity;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long>{

	List<EnderecoEntity> findByCep(String cep);

}
