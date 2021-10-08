package com.dg.gestao.controller;

import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.model.LocacaoModel;
import com.dg.gestao.repository.LocacaoRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name="Locação API", description = "API Locação")
@RequestMapping(value = "/api")
public class LocacaoController {
	
	@Autowired 
	LocacaoRepository repository;
	
	@GetMapping(value="/locacoes")
	public ResponseEntity<?> getLocacoes() {
		return  new ResponseEntity<>(repository.findAll(Sort.by(Sort.Direction.ASC, "data_inicio")), HttpStatus.OK);
	}

	@GetMapping(value="/locacoes/{id}")
	public ResponseEntity<?> getLocacao(@PathVariable final UUID id) {
		try {
			return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/locacoes")
	public ResponseEntity<?> addLocacao(@RequestBody final LocacaoModel locacao) {
		return  new ResponseEntity<>(repository.save(locacao), HttpStatus.CREATED);
	}	
	
	@Operation(description = "Atualizar uma Locação")
	@ResponseStatus(code = HttpStatus.OK)
	@PutMapping(value="/locacoes")
	public ResponseEntity<?> updateVeiculo(@RequestBody final LocacaoModel locacao ) {
		try {
			if(repository.existsById(locacao.getId()))
				return new ResponseEntity<>(repository.save(locacao), HttpStatus.OK);
			else
				return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);	
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}		
	}

}
