package com.portefeuille.portefeuille.controllers;

import java.util.List;
import java.util.Optional;

import com.portefeuille.portefeuille.models.dto.AlunoDTO;
import com.portefeuille.portefeuille.models.entities.Aluno;
import com.portefeuille.portefeuille.services.AlunoService;

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
@RequestMapping("api/v1/alunos")
public class AlunoController {

  @Autowired
  AlunoService service;

  @GetMapping
  public ResponseEntity getAllAlunos() {
    List<Aluno> alunos;

    try {
      alunos = service.obterAlunos();
      return new ResponseEntity<>(alunos, HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/{matricula}")
  public ResponseEntity getAluno(@PathVariable Long matricula) {
    Optional<Aluno> aluno;
    try {
      aluno = service.obterAluno(matricula);
      if (aluno.isPresent()) {
        return new ResponseEntity<>(aluno, HttpStatus.OK);
      } else {
        throw new Exception();
      }
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("/autenticar")
  public ResponseEntity authAluno(@RequestBody AlunoDTO dto) {
    Aluno aluno = Aluno.builder().nome(dto.getNome()).senha(dto.getSenha()).area(dto.getArea())
        .dataNascimento(dto.getDataNascimento()).matricula(dto.getMatricula()).build();

    if (service.autenticarAluno(aluno.getMatricula(), aluno.getSenha())) {
      return new ResponseEntity<>(true, HttpStatus.OK);
    }
    return new ResponseEntity<>(false, HttpStatus.OK);
  }

}
