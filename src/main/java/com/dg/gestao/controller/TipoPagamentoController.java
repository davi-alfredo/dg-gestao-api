package com.dg.gestao.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.dto.ResponseDTO;
import com.dg.gestao.services.TipoPagamentoService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name=" Tipos de Pagamento API", description = "API Tipos Pagamento")
@RequestMapping(value="/api")
public class TipoPagamentoController {
	
	@Autowired 
	TipoPagamentoService service;
	
	@GetMapping(value="/tipos-pagamento")
	public ResponseEntity<?> getTiposPagamento() {		
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}

	@GetMapping(value="/tipos-pagamento/{id}")
	public ResponseEntity<?> getTipoPagamento(@PathVariable int id) {
		try {
			return new ResponseEntity<>(service.getById(id), HttpStatus.OK);
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>(new ResponseDTO("Nenhum registro encontrado para o ID informado."), HttpStatus.NOT_FOUND);
		}
	}
}
