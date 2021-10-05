package com.dg.gestao.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.dto.MovimentacaoMensalDTO;
import com.dg.gestao.model.MovimentacaoFinanceiraModel;
import com.dg.gestao.repository.MovimentacaoFinanceiraRepository;
import com.dg.gestao.service.MovimentacaoFinanceiraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name="Movimentação Financeira API", description = "API Movimentação FInanceira")
@RequestMapping(value="/api")
public class MovimentacaoFinanceiraController {
	
	@Autowired 
	MovimentacaoFinanceiraRepository repository;
	
	@Autowired
	MovimentacaoFinanceiraService service;
	
	@Operation(description = "Obter movimentações financeiras")
	@GetMapping(value="/movimentacoes")
	public ResponseEntity<?> getMovimentacoes() {
		return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
	}

	@Operation(description = "Obter uma movimentação financeira através do Id")
	@GetMapping(value="/movimentacoes/{id}")
	public ResponseEntity<?> getMovimentacao(@PathVariable Long id) {
		try {
			return new ResponseEntity<>(repository.getById(id), HttpStatus.OK);
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(description = "Adicionar uma nova Movimentação Financeira")
	@PostMapping(value="/movimentacoes")
	public ResponseEntity<?> addMovimentacao(@RequestBody MovimentacaoFinanceiraModel movimentacaoFinanceiraModel) {
		return new ResponseEntity<>(repository.save(movimentacaoFinanceiraModel), HttpStatus.CREATED);
	}
	
	
	@Operation(description = "Obter movimentações financeiras")
	@GetMapping(value="/movimentacoes/consolidado/{ano}")
	public ResponseEntity<?> getConsolidadoAnual(@PathVariable int ano) {
		List<MovimentacaoMensalDTO> retorno = service.obterMovimentacaoAnual(ano);
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}
	
	@Operation(description = "Obter movimentações Por Tipo")
	@GetMapping(value="/movimentacoes/tipo/{tipo}")
	public ResponseEntity<?> getPorSituacao(@PathVariable int tipo) {
		List<MovimentacaoFinanceiraModel> retorno = null;
		if(tipo == 0)
			retorno = repository.findAll();
		else
			retorno = repository.getByTipo(tipo);
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}
	
	@Operation(description = "Remover uma movimentação")
	@DeleteMapping(value="/movimentacoes/{id}")
	public ResponseEntity<?> removeCliente(@PathVariable final Long id) {	
		try {
			MovimentacaoFinanceiraModel model = repository.getById(id);
			repository.delete(model);
			return new ResponseEntity<>("Removido com sucesso!", HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(description = "Atualizar uma movimentação")
	@PutMapping(value="/movimentacoes")
	public ResponseEntity<?> updateCliente(@RequestBody final MovimentacaoFinanceiraModel movimentacao) {
		try {		
			if(repository.existsById(movimentacao.getId()))
				return new ResponseEntity<>(repository.save(movimentacao), HttpStatus.OK);
			else 
				return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}


}
