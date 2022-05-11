package com.frankevistorias.api.endereco;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

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

    @NotBlank(message="Bairro vazio")
	@Column(name = "bairro")
	@JsonProperty("bairro")
	private String bairro;

    @NotBlank(message="Cidade vazio")
	@Column(name = "cidade")
	@JsonProperty("cidade")
	private String emcidadeail;

    @NotBlank(message="estado vazio")
	@Column(name = "estado")
	@JsonProperty("estado")
	private String estado;
	
	@Column(name = "complemento")
	@JsonProperty("complemento")
	private String complemento;
    
}
