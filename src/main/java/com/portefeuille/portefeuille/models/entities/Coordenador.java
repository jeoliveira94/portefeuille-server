package com.portefeuille.portefeuille.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coordenador")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Coordenador {

  @Id
  @Column(name = "matricula")
  private Long matricula;

  @Column(name = "nome")
  private String nome;
}