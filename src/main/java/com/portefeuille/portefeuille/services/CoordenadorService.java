package com.portefeuille.portefeuille.services;

import javax.transaction.Transactional;

import com.portefeuille.portefeuille.models.entities.Coordenador;
import com.portefeuille.portefeuille.models.repositories.CoordenadorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordenadorService {
	@Autowired
	CoordenadorRepository repository;

	@Transactional
	public Coordenador salvarCoordenador(Coordenador coordenador) {
		return repository.save(coordenador);
	}

	@Transactional
	public void remover(Coordenador coordenador) {
		repository.delete(coordenador);
	}
}
