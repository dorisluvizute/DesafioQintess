package com.qintess.desafioclinica.controller;

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

import com.qintess.desafioclinica.controller.dto.ExameDto;
import com.qintess.desafioclinica.controller.form.ExameForm;
import com.qintess.desafioclinica.modelo.Exame;
import com.qintess.desafioclinica.repository.ExameRepository;

@RestController
@RequestMapping("/exame")
public class ExameController {

	@Autowired
	ExameRepository exameRepository;
	
	@GetMapping
	public List<ExameDto> lista(String nomeExame){
		if(nomeExame == null){
			List<Exame> exame = exameRepository.findAll();
			return ExameDto.converter(exame);
		} else {
			List<Exame> exame = exameRepository.findByNome(nomeExame);
			return ExameDto.converter(exame);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ExameDto> cadastrar(@RequestBody @Validated ExameForm form, UriComponentsBuilder uriBuilder) {
		Exame exame = form.converter();
		exameRepository.save(exame);
		
		URI uri = uriBuilder.path("/exame/{id}").buildAndExpand(exame.getId()).toUri();
		return ResponseEntity.created(uri).body(new ExameDto(exame));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ExameDto> buscaPorId(@PathVariable Long id){
		Optional<Exame> exame = exameRepository.findById(id);
		if (exame.isPresent()) {
			return ResponseEntity.ok(new ExameDto(exame.get()));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ExameDto> atualizar(@PathVariable Long id, @RequestBody @Validated ExameForm form){
		Optional<Exame> optional = exameRepository.findById(id);
		if (optional.isPresent()) {
			Exame exame = form.atualizar(id, exameRepository);
			return ResponseEntity.ok(new ExameDto(exame));
		} 
		return ResponseEntity.notFound().build();					
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover (@PathVariable Long id){
		Optional<Exame> optional = exameRepository.findById(id);
		if (optional.isPresent()) {
			exameRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();	
	}
	
}
