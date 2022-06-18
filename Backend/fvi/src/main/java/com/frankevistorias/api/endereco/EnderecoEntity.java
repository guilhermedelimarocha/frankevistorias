package com.frankevistorias.api.endereco;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Data
@Entity
@Table(name="endereco")
public class EnderecoEntity implements Serializable{

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@JsonProperty("id")
	private Long	id;

    @NotBlank(message="Logradouro vazio")
	@Column(name = "logradouro")
	@JsonProperty("logradouro")
	private String logradouro;
    
	@NotBlank(message="Numero vazio")
	@Column(name = "numero")
	@JsonProperty("numero")
	private String numero;
	
	@NotBlank(message="CEP vazio")
	@Column(name = "cep")
	@JsonProperty("cep")
	private String cep;

    @NotBlank(message="Bairro vazio")
	@Column(name = "bairro")
	@JsonProperty("bairro")
	private String bairro;

    @NotBlank(message="Cidade vazio")
	@Column(name = "cidade")
	@JsonProperty("cidade")
	private String cidade;

    @NotBlank(message="estado vazio")
	@Column(name = "estado")
	@JsonProperty("estado")
	private String estado;
	
	@Column(name = "complemento")
	@JsonProperty("complemento")
	private String complemento;
	
	@Column(name = "dh_registro")
	@JsonProperty("dh_registro")
	private Timestamp dh_registro;
    
	@Column(name = "dh_alteracao")
	@JsonProperty("dh_alteracao")
	private Timestamp dh_alteracao;
    
}
