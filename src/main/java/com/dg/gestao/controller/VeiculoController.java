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
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.model.VeiculoModel;
import com.dg.gestao.repository.VeiculoRepository;

@RestController
@CrossOrigin
@RequestMapping(value="/api")
public class VeiculoController {
	
	@Autowired 
	VeiculoRepository repository;
	
	@GetMapping(value="/veiculos")
	@CrossOrigin
	public ResponseEntity<?> getVeiculos() {		
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@GetMapping(value="/veiculos/{id}")
	public ResponseEntity<?> getVeiculo(@PathVariable UUID id) {
		try {
			return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/veiculos")
	public ResponseEntity<?> addVeiculo(@RequestBody final VeiculoModel veiculo) {
		return new ResponseEntity<>(repository.save(veiculo), HttpStatus.CREATED);
	}
}
