package com.qintess.desafioclinica.controller;


import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.qintess.desafioclinica.controller.dto.AnimalDto;
import com.qintess.desafioclinica.controller.form.AnimalForm;
import com.qintess.desafioclinica.controller.form.AtualizacaoAnimalForm;
import com.qintess.desafioclinica.modelo.Animal;
import com.qintess.desafioclinica.modelo.Dono;
import com.qintess.desafioclinica.repository.AnimalRepository;
import com.qintess.desafioclinica.repository.DonoRepository;

@RestController
@RequestMapping("/animal")
public class AnimaisController{

	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private DonoRepository donoRepository;
	
	@GetMapping
	public List<AnimalDto> lista(String nomeAnimal){
		if(nomeAnimal == null){
			List<Animal> animais = animalRepository.findAll();
			return AnimalDto.converter(animais);
		} else {
			List<Animal> animais = animalRepository.findByNome(nomeAnimal);
			return AnimalDto.converter(animais);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AnimalDto> cadastrar(@RequestBody @Validated AnimalForm form, UriComponentsBuilder uriBuilder) {
		Animal animal = form.converter(donoRepository);
		animalRepository.save(animal);
		
		URI uri = uriBuilder.path("/animal/{id}").buildAndExpand(animal.getId()).toUri();
		return ResponseEntity.created(uri).body(new AnimalDto(animal));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AnimalDto> buscaPorId(@PathVariable Long id){
		Optional<Animal> animal = animalRepository.findById(id);
		if (animal.isPresent()) {
			return ResponseEntity.ok(new AnimalDto(animal.get()));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AnimalDto> atualizar(@PathVariable Long id, @RequestBody @Validated AtualizacaoAnimalForm form){
		Optional<Animal> optional = animalRepository.findById(id);
		if (optional.isPresent()) {
			Animal animal = form.atualizar(id, animalRepository);
			return ResponseEntity.ok(new AnimalDto(animal));
		} 
		return ResponseEntity.notFound().build();					
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover (@PathVariable Long id){
		Optional<Animal> optional = animalRepository.findById(id);
		if (optional.isPresent()) {
			animalRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();	
	}
	
	
}
