package com.portefeuille.portefeuille.models.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aluno_habilidade")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoHabilidade {

  @EmbeddedId
  AlunoHabilidadePK id;

  @ManyToOne
  @JoinColumn(name = "aluno_matricula", insertable = false, updatable = false)
  private Aluno aluno;

  @ManyToOne
  @JoinColumn(name = "habilidade_id", insertable = false, updatable = false)
  private Habilidade habilidadeId;
}
