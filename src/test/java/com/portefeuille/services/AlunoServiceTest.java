package com.portefeuille.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.portefeuille.portefeuille.PortefeuilleApplication;
import com.portefeuille.portefeuille.models.entities.Aluno;
import com.portefeuille.portefeuille.models.repositories.AlunoRepository;
import com.portefeuille.portefeuille.services.AlunoService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PortefeuilleApplication.class)
public class AlunoServiceTest {
    @Autowired
    AlunoRepository repository;

    @Autowired
    AlunoService service;

    SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void deveRetornarTodosAlunos() throws ParseException {
        Date nascimento = dataFormato.parse("01/01/1999");

        Aluno aluno1 = Aluno.builder().matricula(Long.valueOf(123)).nome("João").area("Medicina")
                .dataNascimento(nascimento).build();
        Aluno aluno2 = Aluno.builder().matricula(Long.valueOf(456)).nome("Maria").area("Engenharia")
                .dataNascimento(nascimento).build();

        Aluno salvo1 = repository.save(aluno1);
        Aluno salvo2 = repository.save(aluno2);

        // ação
        List<Aluno> alunosEncontrados = service.obterAlunos();

        Assertions.assertEquals(alunosEncontrados.size(), 2);

        repository.delete(salvo1);
        repository.delete(salvo2);
    }

    @Test
    public void deveRetornarAluno() throws ParseException {
        Date nascimento = dataFormato.parse("01/01/1999");

        Aluno aluno1 = Aluno.builder().matricula(Long.valueOf(123)).nome("João").area("Medicina")
                .dataNascimento(nascimento).build();

        Aluno salvo1 = repository.save(aluno1);

        // ação
        Optional<Aluno> encontrado1 = service.obterAluno(Long.valueOf(123));
        Optional<Aluno> encontrado2 = service.obterAluno("João");

        Assertions.assertEquals(encontrado1, encontrado2);

        repository.delete(salvo1);
    }
}
