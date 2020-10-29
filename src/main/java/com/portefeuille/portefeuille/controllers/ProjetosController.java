package com.portefeuille.portefeuille.controllers;

import java.util.List;

import com.portefeuille.portefeuille.models.entities.Projeto;
import com.portefeuille.portefeuille.services.ProjetoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/projetos")
public class ProjetosController {

  @Autowired
  ProjetoService service;

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
