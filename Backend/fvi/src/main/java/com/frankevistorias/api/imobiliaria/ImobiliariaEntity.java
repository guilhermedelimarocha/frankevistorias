package com.frankevistorias.api.imobiliaria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.frankevistorias.api.endereco.EnderecoEntity;

import org.hibernate.validator.constraints.br.CNPJ;

import lombok.Data;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Data
@Entity
@Table(name = "imobiliaria")
public class ImobiliariaEntity {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@JsonProperty("id")
	private Long	id;

	@NotBlank(message="Nome Fantasia vazio")
    @Column(name = "nome_fantasia")
	@JsonProperty("nomeFantasia")
	private String nomeFantasia;

	@NotBlank(message="Razao Social vazio")
    @Column(name = "razao_social")
	@JsonProperty("razaoSocial")
	private String razaoSocial;
    
	@CNPJ
	@NotBlank(message="CNPJ vazio")
    @Column(name = "cnpj")
	@JsonProperty("cnpj")
	private String cnpj;

	@Email
	@NotBlank(message="Email vazio")
    @Column(name = "email")
	@JsonProperty("email")
	private String metraemailgemImovel;

	@NotBlank(message="celular vazio")
	@Column(name = "celular")
	@JsonProperty("celular")
	private String celular;

    @JoinColumns({@JoinColumn(name = "id_endereco", referencedColumnName = "id")})
    @JsonProperty("idEndereco")
    @ManyToOne()
    private EnderecoEntity enderecoEntity;
    
}
