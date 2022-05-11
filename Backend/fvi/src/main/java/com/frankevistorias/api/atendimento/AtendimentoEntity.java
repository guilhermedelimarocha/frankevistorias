package com.frankevistorias.api.atendimento;

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
import com.frankevistorias.api.endereco.EnderecoEntity;
import com.frankevistorias.api.imobiliaria.ImobiliariaEntity;
import com.frankevistorias.api.status.StatusEntity;
import com.frankevistorias.api.uriAssets.AssetsEntity;

import lombok.Data;

@Data
@Entity
@Table(name = "atendimento")
public class AtendimentoEntity implements Serializable{

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@JsonProperty("id")
	private Long	id;

    @NotBlank(message = "descricao vazia")
    @Column(name = "descricao")
	@JsonProperty("descricao")
	private String descricao;

    @NotBlank(message = "referencia imovel vazia")
    @Column(name = "referencia_imovel")
	@JsonProperty("referenciaImovel")
	private String referenciaImovel;
    
    @NotBlank(message = "mobilia vazia")
    @Column(name = "mobilia")
	@JsonProperty("mobilia")
	private String mobilia;

    @NotBlank(message = "metragem vazio")
    @Column(name = "metragem_imovel")
	@JsonProperty("metragemImovel")
	private String metragemImovel;

    @NotBlank(message = "urgencia vazio")
    @Column(name = "urgencia_pedido")
	@JsonProperty("urgenciaPedido")
	private String urgenciaPedido;

    @NotBlank(message = " Obs adicionais vazio")
    @Column(name = "obs_adicionais")
	@JsonProperty("obsAdicionais")
	private String obsAdicionais;

    @Column(name = "contestacao")
	@JsonProperty("contestacao")
	private Boolean contestacao;

    @NotBlank(message = "responsavel vazio")
    @Column(name = "responsavel")
	@JsonProperty("responsavel")
	private String responsavel;

    @Column(name = "documento")
	@JsonProperty("documento")
	private String documento;

    @JoinColumns({@JoinColumn(name = "id_imobiliaria", referencedColumnName = "id")})
    @JsonProperty("idImobiliaria")
    @ManyToOne()
    private ImobiliariaEntity imobiliariaEntity;

    @JoinColumns({@JoinColumn(name = "id_endereco", referencedColumnName = "id")})
    @JsonProperty("idEndereco")
    @ManyToOne()
    private EnderecoEntity enderecoEntity;

    @JoinColumns({@JoinColumn(name = "id_status", referencedColumnName = "id")})
    @JsonProperty("idStatus")
    @ManyToOne()
    private StatusEntity statusEntity;
    
}
