package com.qintess.desafioclinica.controller.form;

import javax.persistence.Column;

import com.qintess.desafioclinica.modelo.Veterinario;
import com.qintess.desafioclinica.repository.VeterinarioRepository;
import com.sun.istack.NotNull;

public class AtualizacaoVeterinarioForm {

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
	
	public Veterinario atualizar(Long id, VeterinarioRepository veterinarioRepository) {
		Veterinario veterinario = veterinarioRepository.getOne(id);
		veterinario.setEndereco(this.endereco);
		veterinario.setTelefone(this.telefone);
		
		return veterinario;
	}
}
