package com.qintess.desafioclinica.controller.form;

import javax.persistence.Column;

import com.qintess.desafioclinica.modelo.Animal;
import com.qintess.desafioclinica.repository.AnimalRepository;
import com.sun.istack.NotNull;

public class AtualizacaoAnimalForm {

	@NotNull @Column(length = 45)
	private String nome;
	
	@NotNull @Column(length = 45)
	private String raca;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public Animal atualizar(Long id, AnimalRepository animalRepository) {
		Animal animal = animalRepository.getOne(id);
		animal.setNome(this.nome);
		animal.setRaca(this.raca);
		
		return animal;
	}
}
