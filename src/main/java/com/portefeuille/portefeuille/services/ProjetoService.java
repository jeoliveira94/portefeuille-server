package com.portefeuille.portefeuille.services;

import java.util.List;

import com.portefeuille.portefeuille.models.entities.Projeto;
import com.portefeuille.portefeuille.models.repositories.ProjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

  public List<Projeto> obterProjetosDoCoordenador(Long coordenadorMatricula) {
    return repository.findAllByCoordenadorMatricula(coordenadorMatricula);
  }

  @Transactional
  public Projeto salvarProjeto(Projeto projeto) {
    return repository.save(projeto);
  }

}
