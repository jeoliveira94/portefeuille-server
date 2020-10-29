package com.portefeuille.models.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import com.portefeuille.portefeuille.PortefeuilleApplication;
import com.portefeuille.portefeuille.models.entities.Aluno;
import com.portefeuille.portefeuille.models.repositories.AlunoRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PortefeuilleApplication.class)
public class AlunoRepositoryTest {
	@Autowired
	AlunoRepository repository;

	SimpleDateFormat dataFormato = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	void testeSalvarAluno() throws ParseException {
		// cenario
		Long matricula = Long.valueOf(123456);
		String nome = "Carlos";
		String area = "Ciência da Computação";
		Date nascimento;

		nascimento = dataFormato.parse("01/01/2020");

		Aluno aluno = Aluno.builder().matricula(matricula).nome(nome).dataNascimento(nascimento).area(area).build();

		// ação
		Aluno salvo = repository.save(aluno);

		// verificação
		Assertions.assertNotNull(salvo);

	}

	@Test
	void testeEncontrarAluno() throws ParseException {
		// cenario
		Aluno aluno1 = Aluno.builder()
			.matricula(Long.valueOf(123))
			.nome("João Pedro")
			.dataNascimento(dataFormato.parse("11/11/2011"))
			.area("Engenharia Elétrica")
			.build();

		Aluno aluno2 = Aluno.builder()	
			.matricula(Long.valueOf(456))
			.nome("Maria Clara")
			.dataNascimento(dataFormato.parse("01/05/2001"))
			.area("Medicina")
			.build();
		
		repository.save(aluno1);
		repository.save(aluno2);
		
		// acao
		Optional<Aluno> encontrado1 = repository.findByNome("João Pedro");
		Optional<Aluno> encontrado2 = repository.findByMatricula(Long.valueOf(456));

		// verificacao

		Assertions.assertTrue(encontrado1.isPresent());
		Assertions.assertEquals(aluno1.getMatricula(), 
								encontrado1.get().getMatricula());
		Assertions.assertEquals(aluno1.getNome(), 
								encontrado1.get().getNome());
		Assertions.assertEquals(aluno1.getDataNascimento(), 
								encontrado1.get().getDataNascimento());
		Assertions.assertEquals(aluno1.getArea(), 
								encontrado1.get().getArea());

		Assertions.assertTrue(encontrado2.isPresent());
		Assertions.assertEquals(aluno2.getMatricula(), 
								encontrado2.get().getMatricula());
		Assertions.assertEquals(aluno2.getNome(), 
								encontrado2.get().getNome());
		Assertions.assertEquals(aluno2.getDataNascimento(), 
								encontrado2.get().getDataNascimento());
		Assertions.assertEquals(aluno2.getArea(), 
								encontrado2.get().getArea());
		
	}

	@Test
	@Transactional
	void testeRemoverAluno() throws ParseException {
		// cenario
		Aluno aluno1 = Aluno.builder()
			.matricula(Long.valueOf(123))
			.nome("João Pedro")
			.dataNascimento(dataFormato.parse("11/11/2011"))
			.area("Engenharia Elétrica")
			.build();

		Aluno aluno2 = Aluno.builder()	
			.matricula(Long.valueOf(456))
			.nome("Maria Clara")
			.dataNascimento(dataFormato.parse("01/05/2001"))
			.area("Medicina")
			.build();
		
		repository.save(aluno1);
		repository.save(aluno2);
		
		// acao
		repository.deleteByNome("João Pedro");
		repository.deleteByMatricula(Long.valueOf(456));

		Optional<Aluno> encontrado1 = repository
			.findByMatricula(Long.valueOf(123));
		Optional<Aluno> encontrado2 = repository
			.findByMatricula(Long.valueOf(456));

		// verificacao
		Assertions.assertTrue(encontrado1.isEmpty());
		Assertions.assertTrue(encontrado2.isEmpty());
		
	}
}
