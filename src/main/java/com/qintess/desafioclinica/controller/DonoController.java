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

import com.qintess.desafioclinica.controller.dto.AnimalDto;
import com.qintess.desafioclinica.controller.dto.DonoDto;
import com.qintess.desafioclinica.controller.form.AnimalForm;
import com.qintess.desafioclinica.controller.form.AtualizacaoAnimalForm;
import com.qintess.desafioclinica.controller.form.AtualizacaoDonoForm;
import com.qintess.desafioclinica.controller.form.DonoForm;
import com.qintess.desafioclinica.modelo.Animal;
import com.qintess.desafioclinica.modelo.Dono;
import com.qintess.desafioclinica.repository.DonoRepository;

@RestController
@RequestMapping("/dono")
public class DonoController {

	@Autowired
	private DonoRepository donoRepository;
	
	@GetMapping
	public List<DonoDto> lista(String nomeDono){
		if(nomeDono == null){
			List<Dono> donos = donoRepository.findAll();
			return DonoDto.converter(donos);
		} else {
			List<Dono> donos = donoRepository.findByNome(nomeDono);
			return DonoDto.converter(donos);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<DonoDto> cadastrar(@RequestBody @Validated DonoForm form, UriComponentsBuilder uriBuilder) {
		Dono dono = form.converter();
		donoRepository.save(dono);
		
		URI uri = uriBuilder.path("/dono/{id}").buildAndExpand(dono.getId()).toUri();
		return ResponseEntity.created(uri).body(new DonoDto(dono));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DonoDto> buscaPorId(@PathVariable Long id){
		Optional<Dono> dono = donoRepository.findById(id);
		if (dono.isPresent()) {
			return ResponseEntity.ok(new DonoDto(dono.get()));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<DonoDto> atualizar(@PathVariable Long id, @RequestBody @Validated AtualizacaoDonoForm form){
		Optional<Dono> optional = donoRepository.findById(id);
		if (optional.isPresent()) {
			Dono dono = form.atualizar(id, donoRepository);
			return ResponseEntity.ok(new DonoDto(dono));
		} 
		return ResponseEntity.notFound().build();					
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover (@PathVariable Long id){
		Optional<Dono> optional = donoRepository.findById(id);
		if (optional.isPresent()) {
			donoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();	
	}
}
