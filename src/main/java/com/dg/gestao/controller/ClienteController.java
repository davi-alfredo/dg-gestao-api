package com.dg.gestao.controller;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(description = "Adicionar um novo cliente")
	@PostMapping(value="/clientes")
	public ResponseEntity<?> addCliente(@RequestBody final ClienteModel cliente) {
		return new ResponseEntity<>(repository.save(cliente), HttpStatus.CREATED);
	}	

}
