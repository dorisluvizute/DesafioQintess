package com.qintess.desafioclinica.controller.form;

import java.util.List;

import javax.persistence.Column;

import com.qintess.desafioclinica.modelo.Animal;
import com.qintess.desafioclinica.modelo.Dono;
import com.qintess.desafioclinica.repository.DonoRepository;
import com.sun.istack.NotNull;

public class DonoForm {
	
	@NotNull @Column(length = 45)
	private String nome;
	
	@NotNull @Column(length = 45)
	private String cpf;
	
	@NotNull @Column(length = 45)
	private String endereco;
	
	@NotNull @Column(length = 45)
	private String telefone;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	
	public Dono converter() {
		return new Dono(nome, cpf, endereco, telefone);
	}
	
}
