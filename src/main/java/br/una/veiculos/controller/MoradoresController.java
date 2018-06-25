package br.una.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.una.veiculos.model.Morador;
import br.una.veiculos.repository.MoradorRepository;

@Controller
@RequestMapping("/moradores")
public class MoradoresController {

	@Autowired
	private MoradorRepository moradores;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaMoradores");
		modelAndView.addObject("moradores", moradores.findAll());
		modelAndView.addObject(new Morador());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Morador morador) {
		this.moradores.save(morador);
		return "redirect:/moradores";
	}
	
	@GetMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Morador morador) {
		ModelAndView modelAndView = new ModelAndView("ListaMoradores");
		modelAndView.addObject("moradores", moradores.findAll());
		modelAndView.addObject("morador", morador);
		return modelAndView;
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		this.moradores.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("ListaMoradores");
		modelAndView.addObject("moradores", moradores.findAll());
		modelAndView.addObject(new Morador());
		modelAndView.addObject("globalMessage","Morador removido com sucesso");
		return modelAndView;
	}
	
	
}
