package com.qintess.desafioclinica.controller;

import java.beans.PropertyVetoException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.qintess.desafioclinica.controller.dto.AtendimentoDto;
import com.qintess.desafioclinica.controller.dto.AtendimentoDto;
import com.qintess.desafioclinica.controller.form.AtendimentoForm;
import com.qintess.desafioclinica.controller.form.AtualizacaoAnimalForm;
import com.qintess.desafioclinica.controller.form.AtualizacaoAtendimentoForm;
import com.qintess.desafioclinica.controller.dto.AtendimentoDto;
import com.qintess.desafioclinica.modelo.Atendimentos;
import com.qintess.desafioclinica.modelo.Atendimentos;
import com.qintess.desafioclinica.repository.AnimalRepository;
import com.qintess.desafioclinica.repository.AtendimentoRepository;
import com.qintess.desafioclinica.repository.ExameRepository;
import com.qintess.desafioclinica.repository.MedicamentoRepository;
import com.qintess.desafioclinica.repository.VeterinarioRepository;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

	@Autowired
	AtendimentoRepository atendimentoRepository;
	
	@Autowired
	ExameRepository exameRepository;
	
	@Autowired 
	MedicamentoRepository medicamentoRepository;
	
	@Autowired
	VeterinarioRepository veterinarioRepository;
	
	@Autowired
	AnimalRepository animalRepository;
	
	@GetMapping
	public List<AtendimentoDto> lista(String diagnostico){
		if(diagnostico == null){
			List<Atendimentos> atendimento = atendimentoRepository.findAll();
			return AtendimentoDto.converter(atendimento);
		} else {
			List<Atendimentos> atendimento = atendimentoRepository.findByDiagnostico(diagnostico);
			return AtendimentoDto.converter(atendimento);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AtendimentoDto> cadastrar(@RequestBody @Validated AtendimentoForm form, UriComponentsBuilder uriBuilder) {
		Atendimentos atendimento = form.converter(exameRepository, medicamentoRepository, veterinarioRepository, animalRepository);
		atendimentoRepository.save(atendimento);
		
		URI uri = uriBuilder.path("/atendimento/{id}").buildAndExpand(atendimento.getId()).toUri();
		return ResponseEntity.created(uri).body(new AtendimentoDto(atendimento));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AtendimentoDto> buscaPorId(@PathVariable Long id){
		Optional<Atendimentos> atendimento = atendimentoRepository.findById(id);
		if (atendimento.isPresent()) {
			return ResponseEntity.ok(new AtendimentoDto(atendimento.get()));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AtendimentoDto> atualizar(@PathVariable Long id, @RequestBody @Validated AtualizacaoAtendimentoForm form){
		Optional<Atendimentos> optional = atendimentoRepository.findById(id);
		if (optional.isPresent()) {
			Atendimentos atendimento = form.atualizar(id, atendimentoRepository, exameRepository, medicamentoRepository);
			return ResponseEntity.ok(new AtendimentoDto(atendimento));
		} 
		return ResponseEntity.notFound().build();					
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover (@PathVariable Long id){
		Optional<Atendimentos> optional = atendimentoRepository.findById(id);
		if (optional.isPresent()) {
			atendimentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();	
	}
}
