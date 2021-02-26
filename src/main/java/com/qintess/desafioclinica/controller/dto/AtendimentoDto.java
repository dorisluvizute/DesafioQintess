package com.qintess.desafioclinica.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.qintess.desafioclinica.modelo.Animal;
import com.qintess.desafioclinica.modelo.Atendimentos;
import com.qintess.desafioclinica.modelo.Veterinario;

public class AtendimentoDto {

	private Long id;
	private LocalDateTime dataHora;
	private String diagnostico;
	private Veterinario veterinario;
	private Animal animal;
	
	public AtendimentoDto(Atendimentos atendimento) {
		this.id = atendimento.getId();
		this.dataHora = atendimento.getDataHora();
		this.diagnostico = atendimento.getDiagnostico();
		this.veterinario = atendimento.getVeterinario();
		this.animal = atendimento.getAnimal();
	}
	
	public Long getId() {
		return id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public Animal getAnimal() {
		return animal;
	}
	
	public static List<AtendimentoDto> converter(List<Atendimentos> atendimentos) {		
		return atendimentos.stream().map(AtendimentoDto::new).collect(Collectors.toList());
	}
}
