package com.dg.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.services.SituacaoClienteService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name=" Situações do Cliente API", description = "API Situações do Cliente")
@RequestMapping(value="/api")
public class SituacaoClienteController {
	
	@Autowired 
	SituacaoClienteService service;
	
	@GetMapping(value="/situacoes-cliente")
	public ResponseEntity<?> getSituacoesCliente() {		
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
}
