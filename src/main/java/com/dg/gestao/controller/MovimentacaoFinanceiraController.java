package com.dg.gestao.controller;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.entities.MovimentacaoFinanceira;
import com.dg.gestao.repositories.MovimentacaoFinanceiraRepository;
import com.dg.gestao.services.MovimentacaoFinanceiraService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
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
		return new ResponseEntity<>(repository.findAll(Sort.by(Sort.Direction.DESC, "dataVencimento")), HttpStatus.OK);
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
	
	@Operation(description = "Obter movimentações financeiras")
	@GetMapping(value="/movimentacoes/consolidado/{ano}")
	public ResponseEntity<?> getConsolidadoAnual(@PathVariable int ano) {
		return new ResponseEntity<>(service.getMovimentacaoByYear(ano), HttpStatus.OK);
	}
	
	@Operation(description = "Obter movimentações financeiras por ano e mes")
	@GetMapping(value="/movimentacoes/ano/{ano}/mes/{mes}")
	public ResponseEntity<?> getPorAnoMes(@PathVariable int ano, @PathVariable int mes) {
		return new ResponseEntity<>(service.getMovimentacoesByMonthAndYear(ano, mes), HttpStatus.OK);
	}
	
	@Operation(description = "Obter movimentações Por Situação do Pagamento")
	@GetMapping(value="/movimentacoes/situacao/{situacao}")
	public ResponseEntity<?> getPorSituacao(@PathVariable int situacao) {
		return new ResponseEntity<>(service.getMovimentacoesBySituacaoPagamento(situacao), HttpStatus.OK);
	}
	
	@Operation(description = "Obter movimentações Por Tipo de Movimentação")
	@GetMapping(value="/movimentacoes/tipo-movimentacao/{tipoMovimentacao}")
	public ResponseEntity<?> getByTipoMovimentacao(@PathVariable int tipoMovimentacao) {
		return new ResponseEntity<>(service.getMovimentacoesByTipoMovimentacao(tipoMovimentacao), HttpStatus.OK);
	}
	
	@Operation(description = "Obter movimentações Com alguma Pendencia")
	@GetMapping(value="/movimentacoes/pendente/{situacao}")
	public ResponseEntity<?> getComPendencias(@PathVariable int situacao) {
		List<MovimentacaoFinanceira> retorno = null;
		if (situacao == 0)
			retorno = repository.getComPendencia();
		else 
			retorno = repository.getBySituacaoPagamento(situacao);
		
			
		
		return new ResponseEntity<>(retorno, HttpStatus.OK);
	}

	@Operation(description = "Obter Movimentações do Veículo através do Id")
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value="/movimentacoes/veiculos/{id}")
	public ResponseEntity<?> getMovimentacoesVeiculo(@PathVariable UUID id) {
		try {
			return new ResponseEntity<>(service.getMovimentacoesByVeiculo(id), HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(description = "Obter Movimentações do Cliente através do Id")
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value="/movimentacoes/clientes/{id}")
	public ResponseEntity<?> getMovimentacoesCliente(@PathVariable UUID id) {
		try {
			return new ResponseEntity<>(service.getMovimentacoesByCliente(id), HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(description = "Obter Movimentações do Veículo através do Id")
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value="/movimentacoes/veiculos/{id}/pendentes")
	public ResponseEntity<?> getMovimentacoesPendentesVeiculo(@PathVariable UUID id) {
		try {
			return new ResponseEntity<>(service.getPendenciasByVeiculo(id), HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(description = "Obter Movimentações do Cliente através do Id")
	@ResponseStatus(code = HttpStatus.OK)
	@GetMapping(value="/movimentacoes/clientes/{id}/pendentes")
	public ResponseEntity<?> getMovimentacoesPendentesCliente(@PathVariable UUID id) {
		try {
			return new ResponseEntity<>(service.getPendenciasByCliente(id), HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}
	
	@Operation(description = "Adicionar uma nova Movimentação Financeira")
	@PostMapping(value="/movimentacoes")
	public ResponseEntity<?> addMovimentacao(@RequestBody MovimentacaoFinanceira movimentacaoFinanceiraModel) {
		try {
			return new ResponseEntity<>(service.save(movimentacaoFinanceiraModel), HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_GATEWAY);
		}
	}

	@Operation(description = "Atualizar uma movimentação")
	@PutMapping(value="/movimentacoes")
	public ResponseEntity<?> updateCliente(@RequestBody final MovimentacaoFinanceira movimentacao) {
		try {		
		
			return new ResponseEntity<>(service.update(movimentacao), HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}	
	
	@Operation(description = "Remover uma movimentação")
	@DeleteMapping(value="/movimentacoes/{id}")
	public ResponseEntity<?> removeCliente(@PathVariable final Long id) {	
		try {
			MovimentacaoFinanceira model = repository.getById(id);
			repository.delete(model);
			return new ResponseEntity<>("Removido com sucesso!", HttpStatus.OK);
		}catch(JpaObjectRetrievalFailureException e) {
			return new ResponseEntity<>("Nenhum registro encontrado para o ID informado.", HttpStatus.NOT_FOUND);
		}
	}	
}
