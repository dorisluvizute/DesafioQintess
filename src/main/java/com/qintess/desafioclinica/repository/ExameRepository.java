package com.qintess.desafioclinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.desafioclinica.modelo.Exame;

public interface ExameRepository extends JpaRepository<Exame, Long> {

	List<Exame> findByNome(String nomeExame);
	

}
