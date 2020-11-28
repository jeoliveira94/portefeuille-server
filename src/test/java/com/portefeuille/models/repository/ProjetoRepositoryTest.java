package com.portefeuille.models.repository;

import java.text.SimpleDateFormat;

import com.portefeuille.portefeuille.PortefeuilleApplication;
import com.portefeuille.portefeuille.models.entities.Aluno;
import com.portefeuille.portefeuille.models.entities.Coordenador;
import com.portefeuille.portefeuille.models.entities.Projeto;
import com.portefeuille.portefeuille.models.repositories.AlunoRepository;
import com.portefeuille.portefeuille.models.repositories.CoordenadorRepository;
import com.portefeuille.portefeuille.models.repositories.ProjetoRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PortefeuilleApplication.class)
public class ProjetoRepositoryTest {

	@Autowired
	ProjetoRepository repository;

	@Autowired
	AlunoRepository alunoRepository;

	@Autowired
	CoordenadorRepository coordenadorRepository;

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	void deveSalvarProjeto() throws Exception {
		Coordenador coordenador = Coordenador.builder().matricula(Long.valueOf(123)).nome("João").build();
		Coordenador coordenadorSalvo = coordenadorRepository.save(coordenador);

		Aluno aluno = Aluno.builder().matricula(Long.valueOf(1234)).senha("123").nome("wev")
				.dataNascimento(formato.parse("02/02/2020")).area("xyz").build();
		Aluno alunoSalvo = alunoRepository.save(aluno);

		Projeto projeto = Projeto.builder().alunoMatricula(Long.valueOf("1234"))
				.coordenadorMatricula(Long.valueOf("123")).nome("wev").tipo("x").data(formato.parse("04/02/2001"))
				.status("t").descricao("abcd").build();
		System.out.println(projeto);
		Projeto salvo = repository.save(projeto);

		Assertions.assertNotNull(salvo);
		repository.delete(salvo);
		alunoRepository.delete(alunoSalvo);
		coordenadorRepository.delete(coordenadorSalvo);
	}
}
