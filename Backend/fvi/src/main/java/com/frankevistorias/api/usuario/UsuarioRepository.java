package com.frankevistorias.api.usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

    public Optional<UsuarioEntity> findByEmail(String email);

}