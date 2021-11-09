package com.dg.gestao.controller;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.entities.Veiculo;
import com.dg.gestao.repositories.VeiculoRepository;
import com.dg.gestao.services.VeiculoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name="Veiculos API", description = "API Veículos")
@RequestMapping(value="/api")
public class VeiculoController {
	
	@Autowired 
	VeiculoRepository repository;
	
	@Autowired
	VeiculoService service;
	
	
	@Operation(description = "Obter Veículos Ativos")
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value="/veiculos")
	public ResponseEntity<?> findAll() {		
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@Operation(description = "Obter Veículo através do Id")
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value="/veiculos/{id}")
	public ResponseEntity<?> getById(@PathVariable UUID id) {
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	

	@Operation(description = "Adicionar um novo veículo")
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping(value="/veiculos")
	public ResponseEntity<?> addVeiculo(@RequestBody final Veiculo veiculo) {
		return new ResponseEntity<>(service.save(veiculo), HttpStatus.CREATED);
	}
	
	@Operation(description = "Atualizar um Veículo")
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping(value="/veiculos")
	public ResponseEntity<?> updateVeiculo(@RequestBody final Veiculo veiculo) {
		try {
			return new ResponseEntity<>(service.updateVeiculo(veiculo), HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}		
	}
	
	@Operation(description = "Remover Veículo através do Id")
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
	
	@Operation(description = "Obter Veículo através da situação")
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value="/veiculos/situacao/{idSituacao}")
	public ResponseEntity<?> getVeiculosBySituacao(@PathVariable int idSituacao) {	
		return new ResponseEntity<>(service.getBySituacao(idSituacao), HttpStatus.OK);
	}
}
