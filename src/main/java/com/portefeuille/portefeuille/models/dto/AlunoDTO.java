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
  private String matricula;
  private String nome;
  private String dataNascimento;
  private String area;
}
