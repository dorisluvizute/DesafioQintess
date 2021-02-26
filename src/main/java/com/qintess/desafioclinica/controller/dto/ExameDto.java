package com.qintess.desafioclinica.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.qintess.desafioclinica.modelo.Exame;

public class ExameDto {

	private Long id;
	private String nome;
	
	public ExameDto(Exame exame) {
		this.id = exame.getId();
		this.nome = exame.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public static List<ExameDto> converter(List<Exame> exame) {		
		return exame.stream().map(ExameDto::new).collect(Collectors.toList());
	}
}
