package br.una.veiculos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.una.veiculos.model.Usuario;
import br.una.veiculos.service.UsuarioService;

@RestController
@RequestMapping(value="/usuariores")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Usuario usuario = service.buscarPorId(id);
		return ResponseEntity.ok().body(usuario);
		
	}
}
