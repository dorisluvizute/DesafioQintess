package com.qintess.desafioclinica.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	private String descrição;
	
	public Medicamento() {
	}

	public Medicamento(Long id, String nome, String descrição) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrição = descrição;
	}

	public Medicamento(String nome, String descrição) {
		super();
		this.nome = nome;
		this.descrição = descrição;
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

	public String getDescrição() {
		return descrição;
	}

	public void setDescrição(String descrição) {
		this.descrição = descrição;
	}
	
	
}
