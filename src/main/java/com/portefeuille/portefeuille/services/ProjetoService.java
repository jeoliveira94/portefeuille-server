package com.portefeuille.portefeuille.services;

import java.util.List;

import com.portefeuille.portefeuille.models.entities.Projeto;
import com.portefeuille.portefeuille.models.repositories.ProjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {

  @Autowired
  ProjetoRepository repository;

  public List<Projeto> obterProjetos() {
    return repository.findAll();
  }

  public List<Projeto> obterProjetosDoAluno(Long alunoMatricula) {
    return repository.findAllByAlunoMatricula(alunoMatricula);
  }
}
