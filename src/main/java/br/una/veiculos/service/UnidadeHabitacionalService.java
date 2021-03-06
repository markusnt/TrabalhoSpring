package br.una.veiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.una.veiculos.model.UnidadeHabitacional;
import br.una.veiculos.repository.UnidadeHabitacionalRepository;
import br.una.veiculos.service.exceptions.ObjectNotFoundException;

@Service
public class UnidadeHabitacionalService {

	@Autowired
	private UnidadeHabitacionalRepository repositorio;
	
	public UnidadeHabitacional buscarPorId(Long id) {
		Optional<UnidadeHabitacional> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("UnidadeHabitacional com ID: " + id + " não encontrado"));
	}
}
