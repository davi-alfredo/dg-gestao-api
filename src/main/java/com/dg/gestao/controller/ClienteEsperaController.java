package com.dg.gestao.controller;

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

import com.dg.gestao.entities.ClienteEspera;
import com.dg.gestao.repositories.ClienteEsperaRepository;
import com.dg.gestao.services.ClienteEsperaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Clientes Fila de Espera API", description = "API Clientes na Fila de Espera")
@RequestMapping(value = "/api/")
public class ClienteEsperaController {

	@Autowired
	ClienteEsperaRepository repository;

	@Autowired
	ClienteEsperaService service;

	@Operation(description = "Obter Clientes Ativos")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/clientes-espera")
	public ResponseEntity<?> getClientes() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@Operation(description = "Obter Cliente através do Id")
	@GetMapping(value = "/clientes-espera/{id}")
	public ResponseEntity<?> getCliente(@PathVariable final Integer id) {
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}


	@Operation(description = "Adicionar um novo cliente")
	@PostMapping(value = "/clientes-espera")
	public ResponseEntity<?> addCliente(@RequestBody final ClienteEspera cliente) {
		return new ResponseEntity<>(service.save(cliente), HttpStatus.CREATED);
	}

	@Operation(description = "Atualizar um cliente")
	@DeleteMapping(value = "/clientes-espera/{id}")
	public ResponseEntity<?> removeCliente(@PathVariable final Integer id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>("Removido com sucesso!", HttpStatus.OK);
		} catch (JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}

	@Operation(description = "Atualizar um cliente")
	@PutMapping(value = "/clientes-espera")
	public ResponseEntity<?> updateCliente(@RequestBody final ClienteEspera cliente) {
		try {
			return new ResponseEntity<>(service.updateClienteEspera(cliente), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}

}
