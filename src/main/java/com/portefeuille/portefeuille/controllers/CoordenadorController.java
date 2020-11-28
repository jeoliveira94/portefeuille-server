package com.portefeuille.portefeuille.controllers;

import com.portefeuille.portefeuille.models.dto.CoordenadorDTO;
import com.portefeuille.portefeuille.models.entities.Coordenador;
import com.portefeuille.portefeuille.services.CoordenadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/coordenadores")
public class CoordenadorController {
	@Autowired
	CoordenadorService service;

	@PostMapping
	public ResponseEntity postCoordenador(@RequestBody CoordenadorDTO dto) {

		try {
			Coordenador novoCoordenador = Coordenador.builder().matricula(dto.getMatricula()).nome(dto.getNome())
					.build();

			Coordenador CoordenadorSalvo = service.salvarCoordenador(novoCoordenador);
			return new ResponseEntity<>(CoordenadorSalvo, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
