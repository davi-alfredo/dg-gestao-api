package com.dg.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.repositories.SituacaoVeiculoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name=" Situações do Veículo API", description = "API Situações do Veículo")
@RequestMapping(value="/api")
public class SituacaoVeiculoController {
	
	@Autowired 
	SituacaoVeiculoRepository repository;
	
	@GetMapping(value="/situacoes-veiculo")
	public ResponseEntity<?> getSituacoesVeiculo() {		
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

}
