package br.una.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.una.veiculos.model.Condominio;
import br.una.veiculos.repository.CondominioRepository;

@Controller
@RequestMapping("/condominios")
public class CondominiosController {

	@Autowired
	private CondominioRepository condominios;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaCondominios");
		modelAndView.addObject("condominios", condominios.findAll());
		modelAndView.addObject(new Condominio());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Condominio condominio) {
		this.condominios.save(condominio);
		return "redirect:/condominios";
	}
	
	@GetMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Condominio condominio) {
		ModelAndView modelAndView = new ModelAndView("ListaCondominios");
		modelAndView.addObject("condominios", condominios.findAll());
		modelAndView.addObject("condominio", condominio);
		return modelAndView;
		//return new ModelAndView("ListaCondominios","condominio",condominio);
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		this.condominios.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("ListaCondominios");
		modelAndView.addObject("condominios", condominios.findAll());
		modelAndView.addObject(new Condominio());
		modelAndView.addObject("globalMessage","Condominio removido com sucesso");
		return modelAndView;
	}
	
	
}
