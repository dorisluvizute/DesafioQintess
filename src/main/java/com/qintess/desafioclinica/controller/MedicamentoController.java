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

import com.qintess.desafioclinica.controller.dto.MedicamentoDto;
import com.qintess.desafioclinica.controller.form.MedicamentoForm;
import com.qintess.desafioclinica.controller.form.AtualizacaoMedicamentoForm;
import com.qintess.desafioclinica.modelo.Medicamento;
import com.qintess.desafioclinica.repository.MedicamentoRepository;

@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

	@Autowired
	MedicamentoRepository medicamentoRepository;
	
	@GetMapping
	public List<MedicamentoDto> lista(String nomeMedicamento){
		if(nomeMedicamento == null){
			List<Medicamento> medicamento = medicamentoRepository.findAll();
			return MedicamentoDto.converter(medicamento);
		} else {
			List<Medicamento> medicamento = medicamentoRepository.findByNome(nomeMedicamento);
			return MedicamentoDto.converter(medicamento);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<MedicamentoDto> cadastrar(@RequestBody @Validated MedicamentoForm form, UriComponentsBuilder uriBuilder) {
		Medicamento medicamento = form.converter();
		medicamentoRepository.save(medicamento);
		
		URI uri = uriBuilder.path("/medicamento/{id}").buildAndExpand(medicamento.getId()).toUri();
		return ResponseEntity.created(uri).body(new MedicamentoDto(medicamento));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicamentoDto> buscaPorId(@PathVariable Long id){
		Optional<Medicamento> medicamento = medicamentoRepository.findById(id);
		if (medicamento.isPresent()) {
			return ResponseEntity.ok(new MedicamentoDto(medicamento.get()));
		} 
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<MedicamentoDto> atualizar(@PathVariable Long id, @RequestBody @Validated AtualizacaoMedicamentoForm form){
		Optional<Medicamento> optional = medicamentoRepository.findById(id);
		if (optional.isPresent()) {
			Medicamento medicamento = form.atualizar(id, medicamentoRepository);
			return ResponseEntity.ok(new MedicamentoDto(medicamento));
		} 
		return ResponseEntity.notFound().build();					
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover (@PathVariable Long id){
		Optional<Medicamento> optional = medicamentoRepository.findById(id);
		if (optional.isPresent()) {
			medicamentoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}		
		return ResponseEntity.notFound().build();	
	}
}
