package com.portefeuille.portefeuille.models.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlunoDTO {
  private Long matricula;
  private String senha;
  private String nome;
  private Date dataNascimento;
  private String area;
}
