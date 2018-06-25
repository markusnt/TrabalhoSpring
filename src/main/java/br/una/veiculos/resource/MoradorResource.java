package br.una.veiculos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.una.veiculos.model.Morador;
import br.una.veiculos.service.MoradorService;

@RestController
@RequestMapping(value="/moradoreres")
public class MoradorResource {
	
	@Autowired
	private MoradorService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Morador morador = service.buscarPorId(id);
		return ResponseEntity.ok().body(morador);
		
	}
}
