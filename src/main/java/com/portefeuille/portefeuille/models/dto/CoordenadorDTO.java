package com.portefeuille.portefeuille.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CoordenadorDTO {
	private Long matricula;
	private String nome;
}
