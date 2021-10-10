package com.dg.gestao.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.dg.gestao.model.ClienteModel;
import com.dg.gestao.repository.ClienteRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name="Clientes API", description = "API Clientes")
@RequestMapping(value="/api")
public class ClienteController {
	
	@Autowired 
	ClienteRepository repository;
	
	@Operation(description = "Obter Clientes Ativos")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value="/clientes")
	public ResponseEntity<?> getClientes() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@Operation(description = "Obter Cliente através do Id")
	@GetMapping(value="/clientes/{id}")
	public ResponseEntity<?> getCliente(@PathVariable final UUID id) {
		try {
			return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(description = "Obter Cliente através da situação")
	@GetMapping(value="/clientes/situacao/{isAtivo}")
	public ResponseEntity<?> getClientesBySituacao(@PathVariable final boolean isAtivo) {
		return new ResponseEntity<>(repository.getBySituacao(isAtivo), HttpStatus.OK);		
	}
	
	@Operation(description = "Adicionar um novo cliente")
	@PostMapping(value="/clientes")
	public ResponseEntity<?> addCliente(@RequestBody final ClienteModel cliente) {
		return new ResponseEntity<>(repository.save(cliente), HttpStatus.CREATED);
	}
	
	@Operation(description = "Atualizar um cliente")
	@DeleteMapping(value="/clientes/{id}")
	public ResponseEntity<?> removeCliente(@PathVariable final UUID id) {	
		try {
			ClienteModel model = repository.getById(id);
			repository.delete(model);
			return new ResponseEntity<>("Removido com sucesso!", HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(description = "Atualizar um cliente")
	@PutMapping(value="/clientes")
	public ResponseEntity<?> updateCliente(@RequestBody final ClienteModel cliente) {
		try {		
			if(repository.existsById(cliente.getId()))
				return new ResponseEntity<>(repository.save(cliente), HttpStatus.OK);
			else 
				return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}

}
