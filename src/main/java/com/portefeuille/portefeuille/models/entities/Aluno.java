package com.portefeuille.portefeuille.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {
	@Id
	@Column(name = "matricula")
	private Long matricula;

	@Column(name = "senha")
	private String senha;

	@Column(name = "nome")
	private String nome;

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column(name = "area")
	private String area;

}
