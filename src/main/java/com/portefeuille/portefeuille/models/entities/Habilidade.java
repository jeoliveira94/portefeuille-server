package com.portefeuille.portefeuille.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "habilidade")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Habilidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_habilidade")
	private Long id;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

}
