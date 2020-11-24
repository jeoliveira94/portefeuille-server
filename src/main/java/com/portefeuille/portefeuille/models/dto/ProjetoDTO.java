package com.portefeuille.portefeuille.models.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {
	private Long alunoMatricula;
	private Long coordenadorMatricula;
	private String nome;
	private String tipo;
	private Date data;
	private String status;
	private String descricao;
}
