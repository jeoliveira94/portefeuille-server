package com.portefeuille.portefeuille.controllers;

import java.text.SimpleDateFormat;

import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

import com.portefeuille.portefeuille.models.dto.AlunoDTO;
import com.portefeuille.portefeuille.models.entities.Aluno;
import com.portefeuille.portefeuille.services.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("api/v1/alunos")
public class AlunoController {

  @Autowired
  AlunoService service;

  @GetMapping("/{matricula}")
  public ResponseEntity getAlunos(@PathVariable Long matricula) {
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

  SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

  @GetMapping
  public ResponseEntity getAlunos(@RequestParam(value = "nome", required = false) String nome) {
    List<Aluno> alunos;

    System.out.println(nome);

    try {
      alunos = service.obterAlunos();
      if (nome != null) {
        alunos = alunos.stream().filter(aluno -> aluno.getNome().contains(nome)).collect(Collectors.toList());
      }
      return new ResponseEntity<>(alunos, HttpStatus.OK);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping
  public ResponseEntity postAluno(@RequestBody AlunoDTO dto) {

    try {
      Aluno novoAluno = Aluno.builder().matricula(dto.getMatricula()).senha(dto.getSenha()).nome(dto.getNome())
          .dataNascimento(dto.getDataNascimento()).area(dto.getArea()).build();
      Aluno alunoSalvo = service.salvarAluno(novoAluno);
      return new ResponseEntity<>(alunoSalvo, HttpStatus.CREATED);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("/autenticar")
  public ResponseEntity authAluno(@RequestBody AlunoDTO dto) {

    if (service.autenticarAluno(dto.getMatricula(), dto.getSenha())) {
      return new ResponseEntity<>(true, HttpStatus.OK);
    }
    return new ResponseEntity<>(false, HttpStatus.OK);
  }

}
