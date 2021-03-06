package com.frankevistorias.api.config;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Data
@Entity
@Table(name="config")
public class ConfigEntity implements Serializable {
    
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@JsonProperty("id")
	private Long	id;

    @Column(name = "constante")
	@JsonProperty("constante")
	private String constante;

    @Column(name = "descricao")
	@JsonProperty("descricao")
	private String descricao;
	
	@Column(name = "ativo")
	@JsonProperty("ativo")
	private Boolean ativo;
	
	@Column(name = "nivel")
	@JsonProperty("nivel")
	private Long nivel;
	
	@Column(name = "dh_registro")
	@JsonProperty("dh_registro")
	private Date dh_registro;
    
	@Column(name = "dh_alteracao")
	@JsonProperty("dh_alteracao")
	private Date dh_alteracao;
    
}