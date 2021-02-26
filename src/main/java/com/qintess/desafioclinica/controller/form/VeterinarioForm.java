package com.qintess.desafioclinica.controller.form;

import java.util.List;

import javax.persistence.Column;

import com.qintess.desafioclinica.modelo.Animal;
import com.qintess.desafioclinica.modelo.Dono;
import com.qintess.desafioclinica.modelo.Veterinario;
import com.qintess.desafioclinica.repository.DonoRepository;
import com.sun.istack.NotNull;

public class VeterinarioForm {

	@NotNull 
	private Long crv;
	
	@NotNull @Column(length = 45)
	private String nome;
	
	@NotNull @Column(length = 45)
	private String endereco;
	
	@NotNull @Column(length = 45)
	private String telefone;
	
	@NotNull @Column(length = 45)
	private String especialidade;
	
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
	
	public Veterinario converter() {
		return new Veterinario(crv, nome, endereco, telefone, especialidade);
	}
}
