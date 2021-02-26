package com.qintess.desafioclinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qintess.desafioclinica.modelo.Veterinario;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long>{

	Veterinario findByNome(String nomeVeterinario);

}
