package br.una.veiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.una.veiculos.model.PorteAnimal;
import br.una.veiculos.repository.PorteAnimalRepository;
import br.una.veiculos.service.exceptions.ObjectNotFoundException;

@Service
public class PorteAnimalService {

	@Autowired
	private PorteAnimalRepository repositorio;
	
	public PorteAnimal buscarPorId(Long id) {
		Optional<PorteAnimal> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Porte com ID: " + id + " não encontrado"));
	}
}
