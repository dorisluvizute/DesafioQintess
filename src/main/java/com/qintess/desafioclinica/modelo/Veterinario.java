package com.qintess.desafioclinica.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Veterinario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long crv;

	private String nome;
	private String endereco;
	private String telefone;
	private String especialidade;
	
	public Veterinario() {
	}

	public Veterinario(Long crv, String nome, String endereco, String telefone, String especialidade) {
		super();
		this.crv = crv;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.especialidade = especialidade;
	}

	public Veterinario(String nome, String endereco, String telefone, String especialidade) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.especialidade = especialidade;
	}

	public Long getCrv() {
		return crv;
	}

	public void setCrv(Long crv) {
		this.crv = crv;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	
	
	
	
		
}
