package br.una.veiculos;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.una.veiculos.model.Cidade;
import br.una.veiculos.model.Estado;
import br.una.veiculos.model.Veiculo;
import br.una.veiculos.repository.CidadeRepository;
import br.una.veiculos.repository.EstadoRepository;
import br.una.veiculos.repository.VeiculoRepository;

@SpringBootApplication
public class GestaoVeiculosApplication implements CommandLineRunner {

	@Autowired
	private VeiculoRepository veiculoRepo;
	@Autowired
	private EstadoRepository estadoRepo;
	@Autowired
	private CidadeRepository cidadeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(GestaoVeiculosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Veiculo vei1 = new Veiculo(null, "HPG-4545", "HONDA", "CITY", "2017");
		Veiculo vei2 = new Veiculo(null, "LLG-1234", "FIAT", "Uno", "2011");
		Veiculo vei3 = new Veiculo(null, "AOP-7812", "Volkswagen", "Fusca", "2015");
		
		veiculoRepo.saveAll(Arrays.asList(vei1, vei2, vei3));
		
		Estado est1 = new Estado(null, "MG");
		Estado est2 = new Estado(null, "SP");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		est1.getCidades().addAll(Arrays.asList(c1));
		
		estadoRepo.saveAll(Arrays.asList(est1, est2));
		cidadeRepo.saveAll(Arrays.asList(c1, c2, c3));
		
		
	}
	
	
}
