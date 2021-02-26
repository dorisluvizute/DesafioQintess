package com.qintess.desafioclinica.controller.form;

import javax.persistence.Column;

import com.qintess.desafioclinica.modelo.Dono;
import com.qintess.desafioclinica.repository.DonoRepository;
import com.sun.istack.NotNull;

public class AtualizacaoDonoForm {

	@NotNull @Column(length = 45)
	private String endereco;
	
	@NotNull @Column(length = 45)
	private String telefone;

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
	
	public Dono atualizar(Long id, DonoRepository donoRepository) {
		Dono dono = donoRepository.getOne(id);
		dono.setEndereco(this.endereco);
		dono.setTelefone(this.telefone);
		
		return dono;
	}
}
