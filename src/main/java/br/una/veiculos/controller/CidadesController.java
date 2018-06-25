package br.una.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.una.veiculos.model.Cidade;
import br.una.veiculos.repository.CidadeRepository;

@Controller
@RequestMapping("/cidades")
public class CidadesController {

	@Autowired
	private CidadeRepository cidades;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaCidades");
		modelAndView.addObject("cidades", cidades.findAll());
		modelAndView.addObject(new Cidade());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Cidade cidade) {
		this.cidades.save(cidade);
		return "redirect:/cidades";
	}
	
	@GetMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Cidade cidade) {
		ModelAndView modelAndView = new ModelAndView("ListaCidades");
		modelAndView.addObject("cidades", cidades.findAll());
		modelAndView.addObject("cidade", cidade);
		return modelAndView;
		//return new ModelAndView("ListaCidades","cidade",cidade);
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		this.cidades.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("ListaCidades");
		modelAndView.addObject("cidades", cidades.findAll());
		modelAndView.addObject(new Cidade());
		modelAndView.addObject("globalMessage","Cidade removido com sucesso");
		return modelAndView;
	}
	
	
}
