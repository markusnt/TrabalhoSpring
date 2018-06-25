package br.una.veiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.una.veiculos.model.Estado;
import br.una.veiculos.repository.EstadoRepository;
import br.una.veiculos.service.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repositorio;
	
	public Estado buscarPorId(Long id) {
		Optional<Estado> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Estado com ID: " + id + " não encontrado"));
	}
}
