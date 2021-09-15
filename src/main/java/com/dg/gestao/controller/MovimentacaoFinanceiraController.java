package com.dg.gestao.controller;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.model.MovimentacaoFinanceiraModel;
import com.dg.gestao.model.VeiculoModel;
import com.dg.gestao.repository.MovimentacaoFinanceiraRepository;

@RestController
@RequestMapping(value="/api")
public class MovimentacaoFinanceiraController {
	
	@Autowired 
	MovimentacaoFinanceiraRepository repository;
	
	@GetMapping(value="/movimentacoes")
	public ResponseEntity<?> getMovimentacoes() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@GetMapping(value="/movimentacoes/{id}")
	public ResponseEntity<?> getMovimentacao(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/movimentacoes")
	public ResponseEntity<?> addMovimentacao(VeiculoModel veiculo) {
		return new ResponseEntity<>(new MovimentacaoFinanceiraModel(), HttpStatus.OK);
	}
}
