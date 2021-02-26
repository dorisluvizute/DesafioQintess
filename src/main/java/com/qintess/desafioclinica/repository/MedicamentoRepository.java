package com.qintess.desafioclinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.desafioclinica.modelo.Medicamento;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long>{

	List<Medicamento> findByNome(String nomeMedicamento);

	
}
