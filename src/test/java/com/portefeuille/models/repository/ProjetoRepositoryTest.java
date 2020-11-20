package com.portefeuille.models.repository;

import java.text.SimpleDateFormat;

import com.portefeuille.portefeuille.PortefeuilleApplication;
import com.portefeuille.portefeuille.models.entities.Projeto;
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

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	void deveSalvarProjeto() throws Exception {
		Projeto projeto = Projeto.builder().alunoMatricula(Long.valueOf("123")).coordenadorMatricula(Long.valueOf("23"))
				.nome("wev").tipo("xyz").data(formato.parse("04/02/2001")).status("t").descricao("abcd").build();

		Projeto salvo = repository.save(projeto);

		Assertions.assertNotNull(salvo);
		repository.delete(salvo);
	}
}
