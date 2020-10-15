package com.portefeuille.portefeuille.models.repositories;

import java.util.Optional;

import com.portefeuille.portefeuille.models.entities.Coordenador;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Long> {

	// query methods
	Optional<Coordenador> findByNome(String nome);

	Optional<Coordenador> findByMatricula(Long matricula);

	// delete methods
	void deleteByNome(String nome);

	void deleteByMatricula(Long matricula);
}
