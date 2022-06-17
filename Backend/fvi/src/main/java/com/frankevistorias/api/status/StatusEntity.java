package com.frankevistorias.api.status;

import java.util.Date;

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

/**
 * @author Ilson Junior
 * @since 11/05/2022
 */

@Data
@Entity
@Table(name = "status")

public class StatusEntity {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	@JsonProperty("id")
	private Long	id;

	@NotBlank(message = "Tipo Status vazio")
    @Column(name = "tipo_status")
	@JsonProperty("tipoStatus")
	private String tipoStatus;
	
	@Column(name = "dh_registro")
	@JsonProperty("dh_registro")
	private Date dh_registro;
    
	@Column(name = "dh_alteracao")
	@JsonProperty("dh_alteracao")
	private Date dh_alteracao;

}