package com.frankevistorias.api.pleno;

import java.io.Serializable;
import java.util.Date;

/*
 * @author Guilherme Rocha
 * @since 13/06/2022
 */ 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@Entity
@Table(name="plenoIntegration")
public class PlenoEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@JsonProperty("id")
	private Long id;
	
	@Column(name = "constante")
	@JsonProperty("constante")
	private String constante;

    @Column(name = "descricao")
	@JsonProperty("descricao")
	private String descricao;
	
	@Column(name = "ativo")
	@JsonProperty("ativo")
	private Boolean ativo;
	
	@NotBlank(message = "usuario vazia")
	@Column(name = "usuario")
	@JsonProperty("usuario")
	private String usuario;
	
	@NotBlank(message = "token vazio")
	@Column(name="token")
	@JsonProperty("token")
	private String token;
	
	@NotBlank(message = "senha vazia")
	@Column(name = "senha")
	@JsonProperty("senha")
	private String senha;
	
	@Column(name = "dh_registro")
	@JsonProperty("dh_registro")
	private Date dh_registro;
    
	@Column(name = "dh_alteracao")
	@JsonProperty("dh_alteracao")
	private Date dh_alteracao;
	
	
}
