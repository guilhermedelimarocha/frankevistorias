package com.frankevistorias.api.uriAssets;

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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.frankevistorias.api.atendimento.AtendimentoEntity;
import com.frankevistorias.api.usuario.UsuarioEntity;

import lombok.Data;

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Data
@Entity
@Table(name="assets")
public class AssetsEntity implements Serializable{

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@JsonProperty("id")
	private Long	id;

    @NotBlank(message="uri vazio")
	@Column(name = "uri")
	@JsonProperty("uri")
	private String uri;
    
	@NotBlank(message="formato vazio")
	@Column(name = "formato")
	@JsonProperty("formato")
	private String formato;

	@JoinColumns({@JoinColumn(name = "id_usuario", referencedColumnName = "id")})
    @JsonProperty("idAsset")
    @ManyToOne()
    private UsuarioEntity assetsEntity;

	@JoinColumns({@JoinColumn(name = "id_atendimento", referencedColumnName = "id")})
    @JsonProperty("idAtendimento")
    @ManyToOne()
    private AtendimentoEntity atendimentoEntity;
    
}