package com.portefeuille.portefeuille.models.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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

	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@Column(name = "area")
	private String area;

	@ManyToMany
	@JoinTable(name = "aluno_habilidade", joinColumns = @JoinColumn(name = "aluno_matricula"), inverseJoinColumns = @JoinColumn(name = "habilidade_id"))
	private List<Habilidade> habilidades;
}
