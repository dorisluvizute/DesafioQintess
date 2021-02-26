package com.qintess.desafioclinica.controller.form;

import java.util.List;

import javax.persistence.Column;

import com.qintess.desafioclinica.modelo.Animal;
import com.qintess.desafioclinica.modelo.Dono;
import com.qintess.desafioclinica.repository.DonoRepository;
import com.sun.istack.NotNull;

public class AnimalForm {

	@NotNull @Column(length = 45)
	private String nome;
	
	@NotNull @Column(length = 45)
	private String especie;
	
	@NotNull @Column(length = 45)
	private String raca;
	
	@NotNull
	private Integer idade;
	
	@NotNull 
	private Long idDono;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public Long getNomeDono() {
		return idDono;
	}

	public void setNomeDono(Long idDono) {
		this.idDono = idDono;
	}

	public Animal converter(DonoRepository donoRepository) {
		Dono dono = donoRepository.getOne(idDono);
		return new Animal(nome, especie, raca, idade, dono);
	}
	
}
