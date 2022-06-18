package com.frankevistorias.api.atendimento;

import java.io.Serializable;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.frankevistorias.api.endereco.EnderecoEntity;
import com.frankevistorias.api.imobiliaria.ImobiliariaEntity;
import com.frankevistorias.api.status.StatusEntity;

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
public class AtendimentoDTO implements Serializable{

    private static final long serialVersionUID = 1L;
	
   	@JsonProperty("id")
   	private Long id;

   	@JsonProperty("descricao")
   	private String descricao;

   	@JsonProperty("referenciaImovel")
   	private String referenciaImovel;
       
   	@JsonProperty("mobilia")
   	private String mobilia;

   	@JsonProperty("metragemImovel")
   	private String metragemImovel;

   	@JsonProperty("urgenciaPedido")
   	private String urgenciaPedido;

   	@JsonProperty("obsAdicionais")
   	private String obsAdicionais;

   	@JsonProperty("contestacao")
   	private Boolean contestacao;

   	@JsonProperty("responsavel")
   	private String responsavel;

   @Column(name = "documento")
	@JsonProperty("documento")
	private String documento;

   @JsonProperty("idImobiliaria")
   private ImobiliariaEntity imobiliariaEntity;

   @JsonProperty("idEndereco")
   private EnderecoEntity enderecoEntity;

   @JsonProperty("idStatus")
   private StatusEntity statusEntity;

    public AtendimentoDTO(AtendimentoEntity atendimentoEntity) {

        this.id                 =   atendimentoEntity.getId();
        this.descricao               = atendimentoEntity.getDescricao();
        this.referenciaImovel          =   atendimentoEntity.getReferenciaImovel();
        this.mobilia                =   atendimentoEntity.getMobilia();
        this.metragemImovel              =   atendimentoEntity.getMetragemImovel();
        this.urgenciaPedido            =   atendimentoEntity.getUrgenciaPedido();
        this.obsAdicionais              =   atendimentoEntity.getObsAdicionais();
        this.contestacao              =   atendimentoEntity.getContestacao();
        this.responsavel              =   atendimentoEntity.getResponsavel();
        this.imobiliariaEntity  =   atendimentoEntity.getImobiliariaEntity();
        this.enderecoEntity     =   atendimentoEntity.getEnderecoEntity();
        this.statusEntity     =   atendimentoEntity.getStatusEntity();

    }
    
}