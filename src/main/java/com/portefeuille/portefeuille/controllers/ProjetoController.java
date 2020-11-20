package com.portefeuille.portefeuille.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.portefeuille.portefeuille.models.dto.ProjetoDTO;
import com.portefeuille.portefeuille.models.entities.Projeto;
import com.portefeuille.portefeuille.services.ProjetoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/projetos/")
public class ProjetoController {

  @Autowired
  ProjetoService service;

  SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

  @PostMapping
  public ResponseEntity postProjeto(@RequestBody ProjetoDTO dto) throws Exception {
    Long alunoMatricula = Long.valueOf(dto.getAlunoMatricula());
    Long coordenadorMatricula = Long.valueOf(dto.getCoordenadorMatricula());
    Date data = formato.parse(dto.getData());

    try {
      Projeto projeto = Projeto.builder().alunoMatricula(alunoMatricula).coordenadorMatricula(coordenadorMatricula)
          .nome(dto.getNome()).tipo(dto.getTipo()).data(data).status(dto.getStatus()).descricao(dto.getDescricao())
          .build();

      Projeto projetoSalvo = service.salvarProjeto(projeto);
      return new ResponseEntity<>(projetoSalvo, HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity getProjetos() {
    List<Projeto> projetos;

    try {
      projetos = service.obterProjetos();
      return new ResponseEntity<>(projetos, HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/aluno/{alunoMatricula}")
  public ResponseEntity getProjetosByAluno(@PathVariable Long alunoMatricula) {
    List<Projeto> projetos;

    try {
      projetos = service.obterProjetosDoAluno(alunoMatricula);
      return new ResponseEntity<>(projetos, HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
