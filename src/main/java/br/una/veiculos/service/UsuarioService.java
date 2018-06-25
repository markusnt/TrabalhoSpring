package br.una.veiculos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.una.veiculos.model.Usuario;
import br.una.veiculos.repository.UsuarioRepository;
import br.una.veiculos.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repositorio;
	
	public Usuario buscarPorId(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario com ID: " + id + " não encontrado"));
	}
}
