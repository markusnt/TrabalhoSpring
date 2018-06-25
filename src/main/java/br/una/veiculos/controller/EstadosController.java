package br.una.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.una.veiculos.model.Estado;
import br.una.veiculos.repository.EstadoRepository;

@Controller
@RequestMapping("/estados")
public class EstadosController {

	@Autowired
	private EstadoRepository estados;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaEstados");
		modelAndView.addObject("estados", estados.findAll());
		modelAndView.addObject(new Estado());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Estado estado) {
		this.estados.save(estado);
		return "redirect:/estados";
	}
	
	@GetMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Estado estado) {
		ModelAndView modelAndView = new ModelAndView("ListaEstados");
		modelAndView.addObject("estados", estados.findAll());
		modelAndView.addObject("estado", estado);
		return modelAndView;
		//return new ModelAndView("ListaEstados","estado",estado);
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		this.estados.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("ListaEstados");
		modelAndView.addObject("estados", estados.findAll());
		modelAndView.addObject(new Estado());
		modelAndView.addObject("globalMessage","Estado removido com sucesso");
		return modelAndView;
	}
	
	
}
