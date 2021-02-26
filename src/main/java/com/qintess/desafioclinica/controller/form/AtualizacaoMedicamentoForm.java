package com.qintess.desafioclinica.controller.form;

import javax.persistence.Column;

import com.qintess.desafioclinica.modelo.Medicamento;
import com.qintess.desafioclinica.repository.MedicamentoRepository;
import com.sun.istack.NotNull;

public class AtualizacaoMedicamentoForm {

	@NotNull @Column(length = 45)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Medicamento atualizar(Long id, MedicamentoRepository medicamentoRepository) {
		Medicamento medicamento = medicamentoRepository.getOne(id);
		medicamento.setDescrição(this.descricao);
		
		return medicamento;
	}
	
	
}
