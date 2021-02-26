package com.qintess.desafioclinica.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Animal implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String especie;
	private String raca;
	private Integer idade;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Dono dono;

	public Animal() {
	}

	public Animal(Long id, String nome, String espécie, String raça, Integer idade, Dono dono) {
		super();
		this.id = id;
		this.nome = nome;
		this.especie = espécie;
		this.raca = raça;
		this.idade = idade;
		this.dono = dono;
	}

	public Animal(String nome, String especie, String raca, Integer idade, Dono dono2) {
		super();
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
		this.dono = dono2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String espécie) {
		this.especie = espécie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raça) {
		this.raca = raça;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Dono getDono() {
		return dono;
	}

	public void setDono(Dono dono) {
		this.dono = dono;
	}
	
	
	
}
