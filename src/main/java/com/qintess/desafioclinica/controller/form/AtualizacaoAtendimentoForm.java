package com.qintess.desafioclinica.controller.form;

import java.util.List;

import javax.persistence.Column;

import com.qintess.desafioclinica.modelo.Atendimentos;
import com.qintess.desafioclinica.modelo.Dono;
import com.qintess.desafioclinica.modelo.Exame;
import com.qintess.desafioclinica.modelo.Medicamento;
import com.qintess.desafioclinica.repository.AtendimentoRepository;
import com.qintess.desafioclinica.repository.ExameRepository;
import com.qintess.desafioclinica.repository.MedicamentoRepository;
import com.sun.istack.NotNull;

public class AtualizacaoAtendimentoForm {

	@NotNull @Column(length = 45)
	private String nomeExame;
	
	@NotNull @Column(length = 45)
	private String nomeMedicamento;

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}
	
	public Atendimentos atualizar(Long id, AtendimentoRepository atendimentoRepository, ExameRepository exameRepository,
			MedicamentoRepository medicamentoRepository) {
		
		Atendimentos atendimento = atendimentoRepository.getOne(id);
		
		List<Exame> exame = exameRepository.findByNome(nomeExame);
		List<Medicamento> medicamento = medicamentoRepository.findByNome(nomeMedicamento);
		
		atendimento.setExame(exame);
		atendimento.setMedicamento(medicamento);
		
		return atendimento;
	}
	
	
}
