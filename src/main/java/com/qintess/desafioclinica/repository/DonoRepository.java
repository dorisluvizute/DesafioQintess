package com.qintess.desafioclinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.desafioclinica.modelo.Dono;

public interface DonoRepository extends JpaRepository<Dono, Long>{

	List<Dono> findByNome(String nomeDono);
	
	
}
