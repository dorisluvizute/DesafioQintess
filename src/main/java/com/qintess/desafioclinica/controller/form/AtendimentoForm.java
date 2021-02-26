package com.qintess.desafioclinica.controller.form;

import java.util.List;

import javax.persistence.Column;

import com.qintess.desafioclinica.controller.dto.AtendimentoDto;
import com.qintess.desafioclinica.modelo.Animal;
import com.qintess.desafioclinica.modelo.Atendimentos;
import com.qintess.desafioclinica.modelo.Exame;
import com.qintess.desafioclinica.modelo.Medicamento;
import com.qintess.desafioclinica.modelo.Veterinario;
import com.qintess.desafioclinica.repository.AnimalRepository;
import com.qintess.desafioclinica.repository.AtendimentoRepository;
import com.qintess.desafioclinica.repository.ExameRepository;
import com.qintess.desafioclinica.repository.MedicamentoRepository;
import com.qintess.desafioclinica.repository.VeterinarioRepository;
import com.sun.istack.NotNull;

public class AtendimentoForm  {
	
	@NotNull @Column(length = 45)
	private String nomeExame;
	
	@NotNull @Column(length = 45)
	private String diagnostico;
	
	@NotNull @Column(length = 45)
	private String nomeMedicamento;
	
	@NotNull
	private Long idVeterinario;
	
	@NotNull 
	private Long idAnimal;
	

	public Long getIdVeterinario() {
		return idVeterinario;
	}

	public void setIdVeterinario(Long idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public String getNomeExame() {
		return nomeExame;
	}
	
	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getNomeMedicamento() {
		return nomeMedicamento;
	}

	public void setNomeMedicamento(String nomeMedicamento) {
		this.nomeMedicamento = nomeMedicamento;
	}

	public Long getNomeVeterinario() {
		return idVeterinario;
	}

	public void setNomeVeterinario(Long idVeterinario) {
		this.idVeterinario = idVeterinario;
	}

	public Long getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(Long idAnimal) {
		this.idAnimal = idAnimal;
	}
	
	public Atendimentos converter(ExameRepository exameRepository, MedicamentoRepository medicamentoRepository,
			VeterinarioRepository veterinarioRepository, AnimalRepository animalRepository) {
		
		List<Exame> exame = exameRepository.findByNome(nomeExame);
		List<Medicamento> medicamento = medicamentoRepository.findByNome(nomeMedicamento);
		Veterinario veterinario = veterinarioRepository.getOne(idVeterinario);
		Animal animal = animalRepository.getOne(idAnimal);
		
		return new Atendimentos(exame, diagnostico, medicamento, veterinario, animal);
	}
	
	
}
