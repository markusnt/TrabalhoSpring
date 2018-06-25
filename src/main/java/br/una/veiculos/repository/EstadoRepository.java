package br.una.veiculos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.una.veiculos.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

	
}
