package com.frankevistorias.api.atendimento;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Repository
public interface AtendimentoRepository extends JpaRepository<AtendimentoEntity, Long>{

    public List<AtendimentoEntity> findByReferenciaImovel(String referenciaImovel);

    public List<AtendimentoEntity> findByStatusEntityId(Long statusEntityId);
    
    public List<AtendimentoEntity> findByImobiliariaEntityId(Long imobiliariaEntityId);

    public List<AtendimentoEntity> findByResponsavel(String responsavel);
    
    public Optional<AtendimentoEntity> findById(Long id);

}