package com.dg.gestao.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.SituacaoPagamentoDTO;
import com.dg.gestao.entities.SituacaoPagamento;
import com.dg.gestao.repositories.SituacaoPagamentoRepository;

@Service
public class SituacaoPagamentoService {
	
	@Autowired
	public SituacaoPagamentoRepository repository;
	
	
	public List<SituacaoPagamentoDTO> findAll() {		
		List<SituacaoPagamento> result = repository.findAll();
		return result.stream().map(situacao -> new SituacaoPagamentoDTO(situacao)).collect(Collectors.toList());
	}


	public SituacaoPagamentoDTO getById(int id) {
		try {
			return new SituacaoPagamentoDTO(repository.getById(id));
		}catch(EntityNotFoundException e) {
			throw e;
		}
	}
	
}
