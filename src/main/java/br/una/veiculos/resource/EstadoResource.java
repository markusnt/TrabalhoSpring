package br.una.veiculos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.una.veiculos.model.Estado;
import br.una.veiculos.service.EstadoService;

@RestController
@RequestMapping(value="/estadores")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Estado estado = service.buscarPorId(id);
		return ResponseEntity.ok().body(estado);
		
	}
}
