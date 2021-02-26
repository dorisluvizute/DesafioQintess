package com.qintess.desafioclinica.controller.dto;

import java.util.List;
import java.util.stream.Collectors;
import com.qintess.desafioclinica.modelo.Animal;

public class AnimalDto {

	private Long id;
	private String nome;
	private String especie;
	private String raca;
	
	public AnimalDto(Animal animal) {
		this.id = animal.getId();
		this.nome = animal.getNome();
		this.especie = animal.getEspecie();
		this.raca = animal.getRaca();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEspecie() {
		return especie;
	}

	public String getRaca() {
		return raca;
	}
	
	public static List<AnimalDto> converter(List<Animal> animais) {		
		return animais.stream().map(AnimalDto::new).collect(Collectors.toList());
	}
}
