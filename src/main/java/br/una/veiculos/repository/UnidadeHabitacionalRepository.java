package br.una.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.una.veiculos.model.UnidadeHabitacional;

@Repository
public interface UnidadeHabitacionalRepository extends JpaRepository<UnidadeHabitacional, Long> {

	
}
