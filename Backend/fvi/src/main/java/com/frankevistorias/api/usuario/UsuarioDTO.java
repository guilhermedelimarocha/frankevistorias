package com.frankevistorias.api.usuario;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.frankevistorias.api.endereco.EnderecoEntity;
import com.frankevistorias.api.imobiliaria.ImobiliariaEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO implements Serializable{

    private static final long serialVersionUID = 1L;
	
	@JsonProperty("id")
	private Long	id;
	

	@JsonProperty("nome")
	private String nome;


	@JsonProperty("sobrenome")
	private String sobrenome;

	@JsonProperty("cpf")
	private String cpf;

	@JsonProperty("email")
	private String email;

	@JsonProperty("celular")
	private String celular;

	@JsonProperty("nivel")
	private Long nivel;

    @JsonProperty("idImobiliaria")
    private ImobiliariaEntity imobiliariaEntity;

    @JsonProperty("idEndereco")
    private EnderecoEntity enderecoEntity;

    public UsuarioDTO(UsuarioEntity usuarioEntity) {

        this.id                 =   usuarioEntity.getId();
        this.nome               =   usuarioEntity.getNome();
        this.sobrenome          =   usuarioEntity.getSobrenome();
        this.cpf                =   usuarioEntity.getCpf();
        this.email              =   usuarioEntity.getEmail();
        this.celular            =   usuarioEntity.getCelular();
        this.nivel              =   usuarioEntity.getNivel();
        this.imobiliariaEntity  =   usuarioEntity.getImobiliariaEntity();
        this.enderecoEntity     =   usuarioEntity.getEnderecoEntity();

    }
    
}