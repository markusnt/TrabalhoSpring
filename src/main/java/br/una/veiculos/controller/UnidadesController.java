package br.una.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.una.veiculos.model.UnidadeHabitacional;
import br.una.veiculos.repository.UnidadeHabitacionalRepository;

@Controller
@RequestMapping("/unidades")
public class UnidadesController {

	@Autowired
	private UnidadeHabitacionalRepository unidades;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaUnidadeHabitacionals");
		modelAndView.addObject("unidades", unidades.findAll());
		modelAndView.addObject(new UnidadeHabitacional());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(UnidadeHabitacional unidadehabitacional) {
		this.unidades.save(unidadehabitacional);
		return "redirect:/unidades";
	}
	
	@GetMapping("{id}")
	public ModelAndView editar(@PathVariable("id") UnidadeHabitacional unidadehabitacional) {
		ModelAndView modelAndView = new ModelAndView("ListaUnidadeHabitacionals");
		modelAndView.addObject("unidades", unidades.findAll());
		modelAndView.addObject("unidadehabitacional", unidadehabitacional);
		return modelAndView;
		//return new ModelAndView("ListaUnidadeHabitacionals","unidadehabitacional",unidadehabitacional);
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		this.unidades.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("ListaUnidadeHabitacionals");
		modelAndView.addObject("unidades", unidades.findAll());
		modelAndView.addObject(new UnidadeHabitacional());
		modelAndView.addObject("globalMessage","Unidade removido com sucesso");
		return modelAndView;
	}
	
	
}
