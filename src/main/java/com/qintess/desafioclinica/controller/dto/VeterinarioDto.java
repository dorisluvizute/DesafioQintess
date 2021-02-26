package com.qintess.desafioclinica.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.qintess.desafioclinica.modelo.Veterinario;
import com.qintess.desafioclinica.modelo.Veterinario;

public class VeterinarioDto {

	private Long crv;
	private String nome;
	private String especialidade;
	
	public VeterinarioDto(Veterinario veterinario) {
		this.crv = veterinario.getCrv();
		this.nome = veterinario.getNome();
		this.especialidade = veterinario.getEspecialidade();
	}

	public Long getCrv() {
		return crv;
	}

	public String getNome() {
		return nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}
	
	public static List<VeterinarioDto> converter(List<Veterinario> veterinario) {		
		return veterinario.stream().map(VeterinarioDto::new).collect(Collectors.toList());
	}
}
