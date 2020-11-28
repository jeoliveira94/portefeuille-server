package com.portefeuille.portefeuille.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.portefeuille.portefeuille.models.dto.CoordenadorDTO;
import com.portefeuille.portefeuille.models.entities.Coordenador;
import com.portefeuille.portefeuille.services.CoordenadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/coordenadores")
public class CoordenadorController {
	@Autowired
	CoordenadorService service;

	@GetMapping
	public ResponseEntity getCoordenadores(@RequestParam(value = "nome", required = false) String nome) {
		List<Coordenador> coordenadores;

		System.out.println(nome);

		try {
			coordenadores = service.obterCoordenadores();
			if (nome != null) {
				coordenadores = coordenadores.stream().filter(coordenador -> coordenador.getNome().contains(nome))
						.collect(Collectors.toList());
			}
			return new ResponseEntity<>(coordenadores, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/{matricula}")
	public ResponseEntity getCoordenadorByMatricula(@PathVariable Long matricula) {
		Optional<Coordenador> coordenador;
		try {
			coordenador = service.obterCoordenador(matricula);
			if (coordenador.isPresent()) {
				return new ResponseEntity<>(coordenador, HttpStatus.OK);
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

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
