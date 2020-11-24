package com.portefeuille.portefeuille.services;

import java.util.List;
import java.util.Optional;

import com.portefeuille.portefeuille.models.entities.Aluno;
import com.portefeuille.portefeuille.models.repositories.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlunoService {

  @Autowired
  AlunoRepository repository;

  public List<Aluno> obterAlunos() {
    return repository.findAll();
  }

  public Optional<Aluno> obterAluno(Long matricula) {
    Optional<Aluno> aluno;
    aluno = repository.findByMatricula(matricula);

    return aluno;
  }

  public Optional<Aluno> obterAluno(String nome) {
    Optional<Aluno> aluno;
    aluno = repository.findByNome(nome);

    return aluno;
  }

  public boolean autenticarAluno(Long matricula, String senha) {
    Optional<Aluno> aluno;
    aluno = repository.findByMatricula(matricula);
    if (aluno.isPresent()) {
      return aluno.get().getSenha().equals(senha);
    }
    return false;
  }

  @Transactional
  public Aluno salvarAluno(Aluno aluno) {
    return repository.save(aluno);
  }

}
