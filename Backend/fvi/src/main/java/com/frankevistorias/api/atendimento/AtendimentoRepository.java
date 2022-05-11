package com.frankevistorias.api.atendimento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Repository
public interface AtendimentoRepository extends JpaRepository<AtendimentoEntity, Long>{

}