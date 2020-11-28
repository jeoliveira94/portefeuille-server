package com.portefeuille.controllers;

import java.text.SimpleDateFormat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portefeuille.portefeuille.PortefeuilleApplication;
import com.portefeuille.portefeuille.models.dto.AlunoDTO;
import com.portefeuille.portefeuille.models.entities.Aluno;
import com.portefeuille.portefeuille.services.AlunoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(classes = PortefeuilleApplication.class)
@AutoConfigureMockMvc
public class AlunoControllerTest {
	static final String api = "/api/v1/alunos/";

	@Autowired
	MockMvc mvc;

	@MockBean
	AlunoService service;

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	public void deveSalvarUsuario() throws Exception {
		// cenario
		// dto para virar json
		AlunoDTO dto = AlunoDTO.builder().matricula(123L).senha("123").nome("abc")
				.dataNascimento(formato.parse("02/01/1999")).area("qwerty").build();
		// resposta que será mock
		Aluno aluno = Aluno.builder().matricula(123L).nome("abc").dataNascimento(formato.parse("02/01/1999"))
				.area("qwerty").build();

		// mock salvar
		Mockito.when(service.salvarAluno(Mockito.any(Aluno.class))).thenReturn(aluno);
		String json = new ObjectMapper().writeValueAsString(dto);

		// ação
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(api).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json);

		// verificação
		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void deveObterAluno() {
	}
}
