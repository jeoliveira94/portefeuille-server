package com.portefeuille.portefeuille.services;

import java.util.List;
import java.util.Optional;

import com.portefeuille.portefeuille.models.entities.Projeto;
import com.portefeuille.portefeuille.models.repositories.ProjetoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProjetoService {

  @Autowired
  ProjetoRepository repository;

  public Optional<Projeto> obterProjetoPeloId(Long id) {
    return repository.findById(id);
  }

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
