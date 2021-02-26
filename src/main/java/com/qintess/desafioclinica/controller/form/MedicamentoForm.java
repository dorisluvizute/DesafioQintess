package com.qintess.desafioclinica.controller.form;

import javax.persistence.Column;

import com.qintess.desafioclinica.modelo.Medicamento;
import com.sun.istack.NotNull;

public class MedicamentoForm {

	@NotNull @Column(length = 45)
	private String nome;
	
	@NotNull @Column(length = 45)
	private String descricao;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Medicamento converter() {
		return new Medicamento(nome, descricao);
	}
}
