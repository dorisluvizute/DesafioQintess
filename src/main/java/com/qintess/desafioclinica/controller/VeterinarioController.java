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
import com.qintess.desafioclinica.controller.dto.VeterinarioDto;
import com.qintess.desafioclinica.controller.form.AnimalForm;
import com.qintess.desafioclinica.controller.form.AtualizacaoAnimalForm;
import com.qintess.desafioclinica.controller.form.AtualizacaoVeterinarioForm;
import com.qintess.desafioclinica.controller.form.VeterinarioForm;
import com.qintess.desafioclinica.modelo.Veterinario;
import com.qintess.desafioclinica.modelo.Veterinario;
import com.qintess.desafioclinica.repository.VeterinarioRepository;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

	@Autowired
	private VeterinarioRepository veterinarioRepository;
	
	@GetMapping
	public List<VeterinarioDto> lista(String nomeVeterinario){
		if(nomeVeterinario == null){
			List<Veterinario> veterinario = veterinarioRepository.findAll();
			return VeterinarioDto.converter(veterinario);
		} else {
			List<Veterinario> veterinario = (List<Veterinario>) veterinarioRepository.findByNome(nomeVeterinario);
			return VeterinarioDto.converter(veterinario);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<VeterinarioDto> cadastrar(@RequestBody @Validated VeterinarioForm form, UriComponentsBuilder uriBuilder) {
		Veterinario veterinario = form.converter();
		veterinarioRepository.save(veterinario);
		
		URI uri = uriBuilder.path("/veterinario/{id}").buildAndExpand(veterinario.getCrv()).toUri();
		return ResponseEntity.created(uri).body(new VeterinarioDto(veterinario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<VeterinarioDto> buscaPorCrv(@PathVariable Long id){
		Optional<Veterinario> veterinario = veterinarioRepository.findById(id);
		if (veterinario.isPresent()) {
			return ResponseEntity.ok(new VeterinarioDto(veterinario.get()));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<VeterinarioDto> atualizar(@PathVariable Long id, @RequestBody @Validated AtualizacaoVeterinarioForm form){
		Optional<Veterinario> optional = veterinarioRepository.findById(id);
		if (optional.isPresent()) {
			Veterinario veterinario = form.atualizar(id, veterinarioRepository);
			return ResponseEntity.ok(new VeterinarioDto(veterinario));
		} 
		return ResponseEntity.notFound().build();					
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover (@PathVariable Long id){
		Optional<Veterinario> optional = veterinarioRepository.findById(id);
		if (optional.isPresent()) {
			veterinarioRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();	
	}
	
}
