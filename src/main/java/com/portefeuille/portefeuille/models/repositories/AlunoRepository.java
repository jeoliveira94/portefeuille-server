package com.portefeuille.portefeuille.models.repositories;

import java.util.Optional;

import com.portefeuille.portefeuille.models.entities.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	// query methods
	Optional<Aluno> findByNome(String nome);

	Optional<Aluno> findByMatricula(Long matricula);

	// delete methods
	void deleteByNome(String nome);

	void deleteByMatricula(Long matricula);
}
