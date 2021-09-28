package com.dg.gestao.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.model.VeiculoModel;
import com.dg.gestao.repository.VeiculoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name="Veiculos API", description = "API Veículos")
@RequestMapping(value="/api")
public class VeiculoController {
	
	@Autowired 
	VeiculoRepository repository;
	
	@Operation(description = "Obter Veículos Ativos")
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value="/veiculos")
	public ResponseEntity<?> getVeiculos() {		
		return new ResponseEntity<>(repository.findAll(Sort.by(Sort.Direction.ASC, "fabricante")), HttpStatus.OK);
	}

	@Operation(description = "Obter Veículo através do Id")
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value="/veiculos/{id}")
	public ResponseEntity<?> getVeiculo(@PathVariable UUID id) {
		try {
			return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	

	@Operation(description = "Adicionar um novo veículo")
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value="/veiculos")
	public ResponseEntity<?> addVeiculo(@RequestBody final VeiculoModel veiculo) {
		return new ResponseEntity<>(repository.save(veiculo), HttpStatus.CREATED);
	}
	
	@Operation(description = "Atualizar um Veículo")
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping(value="/veiculos")
	public ResponseEntity<?> updateVeiculo(@RequestBody final VeiculoModel veiculo) {
		try {
			if(repository.existsById(veiculo.getId()))
				return new ResponseEntity<>(repository.save(veiculo), HttpStatus.OK);
			else
				return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);	
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}		
	}
	
	@Operation(description = "Obter Veículo através do Id")
	@ResponseStatus(code = HttpStatus.OK)
	@DeleteMapping(value="/veiculos/{id}")
	public ResponseEntity<?> removeVeiculo(@PathVariable UUID id) {
		try {
			repository.delete(repository.getById(id));
			return new ResponseEntity<>("Removido com sucesso!", HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
}
