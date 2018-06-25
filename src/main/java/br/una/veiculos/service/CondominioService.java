package br.una.veiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.una.veiculos.model.Condominio;
import br.una.veiculos.repository.CondominioRepository;
import br.una.veiculos.service.exceptions.ObjectNotFoundException;

@Service
public class CondominioService {

	@Autowired
	private CondominioRepository repositorio;
	
	public Condominio buscarPorId(Long id) {
		Optional<Condominio> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Condominio com ID: " + id + " não encontrado"));
	}
}
