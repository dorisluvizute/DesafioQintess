package com.qintess.desafioclinica.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.qintess.desafioclinica.modelo.Medicamento;
import com.qintess.desafioclinica.modelo.Medicamento;

public class MedicamentoDto {

	private Long id;
	private String nome;
	private String descricao;
	
	public MedicamentoDto(Medicamento medicamento) {
		this.id = medicamento.getId();
		this.nome = medicamento.getNome();
		this.descricao = medicamento.getDescrição();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static List<MedicamentoDto> converter(List<Medicamento> medicamento) {		
		return medicamento.stream().map(MedicamentoDto::new).collect(Collectors.toList());
	}
}
