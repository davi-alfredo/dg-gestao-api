package com.dg.gestao.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.dto.ResponseDTO;
import com.dg.gestao.repositories.SituacaoPagamentoRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name=" Situações de Pagamento API", description = "API Situações do Pagamento")
@RequestMapping(value="/api")
public class SituacaoPagamentoController {
	
	@Autowired 
	SituacaoPagamentoRepository repository;
	
	@GetMapping(value="/situacoes-pagamento")
	public ResponseEntity<?> getSituacoesPagamento() {		
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@GetMapping(value="/situacoes-pagamento/{id}")
	public ResponseEntity<?> getSituacoesPagamento(@PathVariable int id) {
		try {
			return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>(new ResponseDTO("Nenhum registro encontrado para o ID informado."), HttpStatus.NOT_FOUND);
		}
	}
}
