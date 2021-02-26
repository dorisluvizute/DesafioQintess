package com.qintess.desafioclinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.desafioclinica.modelo.Atendimentos;

public interface AtendimentoRepository extends JpaRepository<Atendimentos, Long>{

	List<Atendimentos> findById(Integer idAtendimento);

	List<Atendimentos> findByDiagnostico(String diagnostico);

	
}
