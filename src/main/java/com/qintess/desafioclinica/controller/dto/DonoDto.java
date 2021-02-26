package com.qintess.desafioclinica.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.qintess.desafioclinica.modelo.Dono;

public class DonoDto {

	private Long id;
	private String nome;
	private String endereco;
	private String telefone;
	
	public DonoDto(Dono dono) {
		this.nome = dono.getNome();
		this.endereco = dono.getEndereco();
		this.telefone = dono.getTelefone();
	}

	
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public static List<DonoDto> converter(List<Dono> donos) {		
		return donos.stream().map(DonoDto::new).collect(Collectors.toList());
	}
	
	
}
