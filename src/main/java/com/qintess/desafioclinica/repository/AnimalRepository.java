package com.qintess.desafioclinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import com.qintess.desafioclinica.modelo.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

	List<Animal> findByNome(String nomeAnimal);
	
}
