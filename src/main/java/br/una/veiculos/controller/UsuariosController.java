package br.una.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.una.veiculos.model.Cidade;
import br.una.veiculos.model.Usuario;
import br.una.veiculos.repository.CidadeRepository;
import br.una.veiculos.repository.CondominioRepository;
import br.una.veiculos.repository.EstadoRepository;
import br.una.veiculos.repository.MoradorRepository;
import br.una.veiculos.repository.UnidadeHabitacionalRepository;
import br.una.veiculos.repository.UsuarioRepository;
import br.una.veiculos.repository.VeiculoRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private UsuarioRepository usuarios;
	private CidadeRepository cidades;
	private CondominioRepository condominios;
	private EstadoRepository estados;
	private MoradorRepository moradores;
	private UnidadeHabitacionalRepository unidades;
	private VeiculoRepository veiculos;
	
	public UsuariosController(UsuarioRepository usuarios, CidadeRepository cidades, CondominioRepository condominios, EstadoRepository estados, MoradorRepository moradores, UnidadeHabitacionalRepository unidades, VeiculoRepository veiculos) {
		this.usuarios = usuarios;
		this.cidades = cidades;
		this.condominios = condominios;
		this.estados = estados;
		this.moradores = moradores;
		this.unidades = unidades;
		this.veiculos = veiculos;
	}
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("ListaUsuarios");
		modelAndView.addObject("usuarios", usuarios.findAll());
		modelAndView.addObject(new Usuario());
		return modelAndView;
	}
	
	@PostMapping
	public String salvar(Usuario usuario) {
		this.usuarios.save(usuario);
		return "redirect:/usuarios";
	}
	
	@GetMapping("{id}")
	public ModelAndView editar(@PathVariable("id") Usuario usuario, @RequestParam Long id) {
		ModelAndView modelAndView = new ModelAndView("ListaUsuarios");
		modelAndView.addObject("usuarios", usuarios.findById(id));
		modelAndView.addObject("cidades", cidades.findAll());
		modelAndView.addObject("condominios", condominios.findAll());
		modelAndView.addObject("estados", estados.findAll());
		modelAndView.addObject("moradores", moradores.findAll());
		modelAndView.addObject("unidades", unidades.findAll());
		modelAndView.addObject("veiculos", veiculos.findAll());
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		this.usuarios.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("ListaUsuarios");
		modelAndView.addObject("usuarios", usuarios.findAll());
		modelAndView.addObject(new Usuario());
		modelAndView.addObject("globalMessage","Usuario removido com sucesso");
		return modelAndView;
	}
	
	
}
