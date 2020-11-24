package com.portefeuille.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portefeuille.portefeuille.PortefeuilleApplication;
import com.portefeuille.portefeuille.models.dto.ProjetoDTO;
import com.portefeuille.portefeuille.models.entities.Projeto;
import com.portefeuille.portefeuille.services.ProjetoService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("teste")
@SpringBootTest(classes = PortefeuilleApplication.class)
@AutoConfigureMockMvc
public class ProjetoControllerTest {
	static final String api = "/api/v1/projetos/";

	@Autowired
	MockMvc mvc;

	@Autowired
	ProjetoService service;

	SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");

	@Test
	void deveSalvarProjeto() throws Exception {
		ProjetoDTO dto = ProjetoDTO.builder().alunoMatricula(123L).coordenadorMatricula(23L).nome("wev").tipo("xyz")
				.data(new Date("04/02/2001")).status("t").descricao("abcd").build();

		System.out.println(dto);

		Projeto projeto = Projeto.builder().alunoMatricula(Long.valueOf(dto.getAlunoMatricula()))
				.coordenadorMatricula(Long.valueOf(dto.getCoordenadorMatricula())).nome(dto.getNome()).tipo(dto.getTipo())
				.data(dto.getData()).status(dto.getStatus()).descricao(dto.getDescricao()).build();

		System.out.println(projeto);

		Mockito.when(service.salvarProjeto(Mockito.any(Projeto.class))).thenReturn(projeto);
		String json = new ObjectMapper().writeValueAsString(dto);

		System.out.println(json);

		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(api).accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON).content(json);

		System.out.println(request);

		mvc.perform(request).andExpect(MockMvcResultMatchers.status().isCreated());
	}
}
