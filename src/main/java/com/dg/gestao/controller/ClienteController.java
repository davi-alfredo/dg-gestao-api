package com.dg.gestao.controller;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

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

import com.dg.gestao.entities.Cliente;
import com.dg.gestao.repositories.ClienteRepository;
import com.dg.gestao.services.ClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name = "Clientes API", description = "API Clientes")
@RequestMapping(value = "/api")
public class ClienteController {

	@Autowired
	ClienteRepository repository;

	@Autowired
	ClienteService service;

	@Operation(description = "Obter Clientes Ativos")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/clientes")
	public ResponseEntity<?> getClientes() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@Operation(description = "Obter Cliente através do Id")
	@GetMapping(value = "/clientes/{id}")
	public ResponseEntity<?> getCliente(@PathVariable final UUID id) {
		try {
			return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}

	@Operation(description = "Obter Cliente através da situação")
	@GetMapping(value = "/clientes/situacao/{idSituacao}")
	public ResponseEntity<?> getClientesBySituacao(@PathVariable final int idSituacao) {
		return new ResponseEntity<>(service.getBySituacao(idSituacao), HttpStatus.OK);
	}

	@Operation(description = "Adicionar um novo cliente")
	@PostMapping(value = "/clientes")
	public ResponseEntity<?> addCliente(@RequestBody final Cliente cliente) {
		return new ResponseEntity<>(service.save(cliente), HttpStatus.CREATED);
	}

	@Operation(description = "Atualizar um cliente")
	@DeleteMapping(value = "/clientes/{id}")
	public ResponseEntity<?> removeCliente(@PathVariable final UUID id) {
		try {
			repository.deleteById(id);
			return new ResponseEntity<>("Removido com sucesso!", HttpStatus.OK);
		} catch (JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}

	@Operation(description = "Atualizar um cliente")
	@PutMapping(value = "/clientes")
	public ResponseEntity<?> updateCliente(@RequestBody final Cliente cliente) {
		try {
			return new ResponseEntity<>(service.updateCliente(cliente), HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}

}
