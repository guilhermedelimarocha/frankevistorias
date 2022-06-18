package com.frankevistorias.api.uriAssets;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.frankevistorias.api.atendimento.AtendimentoEntity;
import com.frankevistorias.api.endereco.EnderecoEntity;
import com.frankevistorias.api.imobiliaria.ImobiliariaEntity;
import com.frankevistorias.api.usuario.UsuarioDTO;
import com.frankevistorias.api.usuario.UsuarioEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty("id")
	private Long id;

	@JsonProperty("formato")
	private String formato;

	@JsonProperty("uri")
	private String uri;

	@JsonProperty("idUsuario")
	private UsuarioEntity usuarioEntity;

	@JsonProperty("idAtendimento")
	private AtendimentoEntity atendimentoEntity;

	public AssetsDTO(AssetsEntity assetsEntity) {

		this.id = assetsEntity.getId();
		this.formato = assetsEntity.getFormato();
		this.uri = assetsEntity.getUri();
		this.usuarioEntity = assetsEntity.getUsuarioEntity();
		this.atendimentoEntity = assetsEntity.getAtendimentoEntity();

	}
}
