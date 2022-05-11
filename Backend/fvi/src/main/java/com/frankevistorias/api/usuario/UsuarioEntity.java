package com.frankevistorias.api.usuario;

import java.io.Serializable;

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
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.frankevistorias.api.endereco.EnderecoEntity;
import com.frankevistorias.api.imobiliaria.ImobiliariaEntity;

import org.hibernate.validator.constraints.br.CPF;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class UsuarioEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@JsonProperty("id")
	private Long	id;
	
	@NotBlank(message = "Nome vazio")
    @Column(name = "nome")
	@JsonProperty("nome")
	private String nome;

	@NotBlank(message = "Sobrenome vazio")
    @Column(name = "sobrenome")
	@JsonProperty("sobrenome")
	private String sobrenome;

	@CPF
	@NotBlank(message = "CPF vazio")
    @Column(name = "cpf")
	@JsonProperty("cpf")
	private String cpf;

	@Email
	@NotBlank(message = "email vazio")
    @Column(name = "email")
	@JsonProperty("email")
	private String email;

	@NotBlank(message = "Celular vazio")
    @Column(name = "celular")
	@JsonProperty("celular")
	private String celular;

	@NotBlank(message = "senha vazia")
    @Column(name = "senha")
	@JsonProperty("senha")
	private String senha;

	@NotNull
	@Column(name = "nivel")
	@JsonProperty("nivel")
	private Long nivel;

    @JoinColumns({@JoinColumn(name = "id_imobiliaria", referencedColumnName = "id")})
    @JsonProperty("idImobiliaria")
    @ManyToOne()
    private ImobiliariaEntity imobiliariaEntity;

    @JoinColumns({@JoinColumn(name = "id_endereco", referencedColumnName = "id")})
    @JsonProperty("idEndereco")
    @ManyToOne()
    private EnderecoEntity enderecoEntity;

}
