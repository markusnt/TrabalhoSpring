package br.una.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.una.veiculos.model.Veiculo;
import br.una.veiculos.repository.VeiculoRepository;

@Controller
@RequestMapping("/veiculos")
public class VeiculosController {

	@Autowired
	private VeiculoRepository veiculos;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaVeiculos");
		modelAndView.addObject("veiculos", veiculos.findAll());
		modelAndView.addObject(new Veiculo());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Veiculo veiculo) {
		this.veiculos.save(veiculo);
		return "redirect:/veiculos";
	}
	
	@GetMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Veiculo veiculo) {
		ModelAndView modelAndView = new ModelAndView("ListaVeiculos");
		modelAndView.addObject("veiculos", veiculos.findAll());
		modelAndView.addObject("veiculo", veiculo);
		return modelAndView;
		//return new ModelAndView("ListaVeiculos","veiculo",veiculo);
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		this.veiculos.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("ListaVeiculos");
		modelAndView.addObject("veiculos", veiculos.findAll());
		modelAndView.addObject(new Veiculo());
		modelAndView.addObject("globalMessage","Veículo removido com sucesso");
		return modelAndView;
	}
	
	
}
