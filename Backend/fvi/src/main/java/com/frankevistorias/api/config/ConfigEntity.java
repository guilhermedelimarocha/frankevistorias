package com.frankevistorias.api.config;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
    
}
