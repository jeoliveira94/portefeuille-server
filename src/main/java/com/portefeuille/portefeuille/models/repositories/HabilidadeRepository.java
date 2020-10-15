package com.portefeuille.portefeuille.models.repositories;

import java.util.List;
import java.util.Optional;

import com.portefeuille.portefeuille.models.entities.Habilidade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HabilidadeRepository extends JpaRepository<Habilidade, Long> {
	// query methods
	Optional<Habilidade> findByNome(String nome);

	Optional<List<Habilidade>> findAllByTipo(String tipo);
}
