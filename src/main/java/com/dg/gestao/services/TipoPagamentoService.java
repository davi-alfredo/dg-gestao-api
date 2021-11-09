package com.dg.gestao.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.TipoPagamentoDTO;
import com.dg.gestao.entities.TipoPagamento;
import com.dg.gestao.repositories.TipoPagamentoRepository;

@Service
public class TipoPagamentoService {
	
	@Autowired
	public TipoPagamentoRepository repository;
	
	
	public List<TipoPagamentoDTO> findAll() {		
		List<TipoPagamento> result = repository.findAll();
		return result.stream().map(tipo -> new TipoPagamentoDTO(tipo)).collect(Collectors.toList());
	}


	public Object getById(int id) {
		try {
			return new TipoPagamentoDTO(repository.getById(id));
		}catch(EntityNotFoundException e) {
			throw e;
		}
	}
	
}
