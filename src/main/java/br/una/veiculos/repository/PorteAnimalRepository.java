package br.una.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.una.veiculos.model.PorteAnimal;

@Repository
public interface PorteAnimalRepository extends JpaRepository<PorteAnimal, Long> {

	
}
