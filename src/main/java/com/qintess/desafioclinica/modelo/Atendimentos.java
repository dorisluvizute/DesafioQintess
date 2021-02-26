package com.qintess.desafioclinica.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Atendimentos implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private LocalDateTime dataHora = LocalDateTime.now();
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Exame.class)
	private List<Exame> exame = new ArrayList<Exame>();
	
	private String diagnostico;
	
	@OneToMany(fetch = FetchType.LAZY, targetEntity = Medicamento.class)
	private List<Medicamento> medicamento = new ArrayList<Medicamento>();
	
	@OneToOne
	private Veterinario veterinario;
	
	@OneToOne
	private Animal animal;
	
	public Atendimentos(Long id, List<Exame> exame, String diagnostico, List<Medicamento> medicamento,
			Veterinario veterinario, Animal animal) {
		super();
		this.id = id;
		this.exame = exame;
		this.diagnostico = diagnostico;
		this.medicamento = medicamento;
		this.veterinario = veterinario;
		this.animal = animal;
	}

	@SuppressWarnings("unchecked")
	public Atendimentos(List<Exame> exame2, String diagnostico, List<Medicamento> medicamento2, Veterinario veterinario,
			Animal animal) {
		super();
		this.exame = exame2;
		this.diagnostico = diagnostico;
		this.medicamento = medicamento2;
		this.veterinario = veterinario;
		this.animal = animal;
	}	

	public Atendimentos() {
	}

	public Atendimentos(Long id, LocalDateTime dataHora, List<Exame> exame, String diagnostico,
			List<Medicamento> medicamento, Veterinario veterinario, Animal animal) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.exame = exame;
		this.diagnostico = diagnostico;
		this.medicamento = medicamento;
		this.veterinario = veterinario;
		this.animal = animal;
	}	

	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public List<Exame> getExame() {
		return exame;
	}

	public void setExame(List<Exame> exame) {
		this.exame = exame;
	}

	public String getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	} 

	public List<Medicamento> getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(List<Medicamento> medicamento) {
		this.medicamento = medicamento;
	}

	public Veterinario getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}

}
