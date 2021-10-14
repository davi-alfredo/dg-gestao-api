package com.dg.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.repository.TipoMovimentacaoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name=" Tipos de Movimentação API", description = "API Tipos Movimentação")
@RequestMapping(value="/api")
public class TipoMovimentacaoController {
	
	@Autowired 
	TipoMovimentacaoRepository repository;
	
	@GetMapping(value="/tipos-movimentacao")
	public ResponseEntity<?> getTiposMovimentacao() {		
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}	
}
