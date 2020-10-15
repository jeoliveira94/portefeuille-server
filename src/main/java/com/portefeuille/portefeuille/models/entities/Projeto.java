package com.portefeuille.portefeuille.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "projeto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Projeto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_projeto")
  private int id;

  @Column(name = "aluno_matricula")
  private Long alunoMatricula;

  @Column(name = "coordenador_matricula")
  private Long coordenadorMatricula;

  @Column(name = "nome")
  private String nome;

  @Column(name = "tipo")
  private String tipo;

  @Column(name = "data")
  private Date data;

  @Column(name = "status")
  private String status;

  @Column(name = "descricao")
  private String descricao;
}
