package br.una.veiculos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.una.veiculos.model.UnidadeHabitacional;
import br.una.veiculos.service.UnidadeHabitacionalService;

@RestController
@RequestMapping(value="/unidaderes")
public class UnidadeHabitacionalResource {
	
	@Autowired
	private UnidadeHabitacionalService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		UnidadeHabitacional unidadehabitacional = service.buscarPorId(id);
		return ResponseEntity.ok().body(unidadehabitacional);
		
	}
}
