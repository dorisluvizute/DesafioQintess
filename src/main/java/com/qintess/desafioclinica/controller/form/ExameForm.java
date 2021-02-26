package com.qintess.desafioclinica.controller.form;

import java.util.List;

import javax.persistence.Column;

import com.qintess.desafioclinica.modelo.Exame;
import com.qintess.desafioclinica.modelo.Exame;
import com.qintess.desafioclinica.modelo.Dono;
import com.qintess.desafioclinica.repository.AnimalRepository;
import com.qintess.desafioclinica.repository.DonoRepository;
import com.qintess.desafioclinica.repository.ExameRepository;
import com.sun.istack.NotNull;

public class ExameForm {

	@NotNull @Column(length = 45)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Exame converter() {
		return new Exame(nome);
	}
	
	public Exame atualizar(Long id, ExameRepository exameRepository) {
		Exame exame = exameRepository.getOne(id);
		exame.setNome(this.nome);
		
		return exame;
	}
}
