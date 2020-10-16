package com.portefeuille.portefeuille.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AlunoHabilidadePK implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  @Column(name = "aluno_matricula")
  private Long alunoMatricula;

  @Column(name = "habilidade_id")
  private Long habilidadeId;
}
