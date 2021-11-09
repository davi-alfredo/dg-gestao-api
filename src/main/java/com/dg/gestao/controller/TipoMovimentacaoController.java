package com.dg.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.services.TipoMovimentacaoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name=" Tipos de Movimentação API", description = "API Tipos Movimentação")
@RequestMapping(value="/api")
public class TipoMovimentacaoController {
	
	@Autowired 
	TipoMovimentacaoService service;
	
	@GetMapping(value="/tipos-movimentacao")
	public ResponseEntity<?> getTiposMovimentacao() {		
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}	
}
