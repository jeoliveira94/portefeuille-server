package com.portefeuille.portefeuille.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {
	private String alunoMatricula;
	private String coordenadorMatricula;
	private String nome;
	private String tipo;
	private String data;
	private String status;
	private String descricao;
}
