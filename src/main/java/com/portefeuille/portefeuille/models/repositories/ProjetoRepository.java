package com.portefeuille.portefeuille.models.repositories;

import java.util.List;
import java.util.Optional;

import com.portefeuille.portefeuille.models.entities.Projeto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
	// query methods
	Optional<Projeto> findByNome(String nome);

	List<Projeto> findAllByTipo(String tipo);

	List<Projeto> findAll();

	List<Projeto> findAllByAlunoMatricula(Long alunoMatricula);

	// delete methods
	void deleteByNome(String nome);

}
