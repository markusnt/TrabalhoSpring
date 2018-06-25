package br.una.veiculos.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.una.veiculos.model.Condominio;
import br.una.veiculos.service.CondominioService;

@RestController
@RequestMapping(value="/condominiores")
public class CondominioResource {
	
	@Autowired
	private CondominioService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
		Condominio condominio = service.buscarPorId(id);
		return ResponseEntity.ok().body(condominio);
		
	}
}
