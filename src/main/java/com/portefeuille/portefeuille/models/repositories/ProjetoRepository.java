package com.portefeuille.portefeuille.models.repositories;

import java.util.List;
import java.util.Optional;

import com.portefeuille.portefeuille.models.entities.Projeto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
	// query methods
	Optional<Projeto> findByNome(String nome);

	List<Projeto> findAllByTipo(String tipo);

	List<Projeto> findAllByCoordenador(Long matriculaCoordenador);

	List<Projeto> findAllByAluno(Long matriculaAluno);

	// delete methods
	void deleteByNome(String nome);

	void deleteAllByCoordenador(Long matriculaCoordenador);

	void deleteAllByAluno(Long matriculaAluno);

}
