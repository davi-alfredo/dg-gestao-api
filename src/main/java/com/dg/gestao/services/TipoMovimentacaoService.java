package com.dg.gestao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.TipoMovimentacaoDTO;
import com.dg.gestao.entities.TipoMovimentacao;
import com.dg.gestao.repositories.TipoMovimentacaoRepository;

@Service
public class TipoMovimentacaoService {
	
	@Autowired
	public TipoMovimentacaoRepository repository;
	
	
	public List<TipoMovimentacaoDTO> findAll() {		
		List<TipoMovimentacao> result = repository.findAll();
		return result.stream().map(tipo -> new TipoMovimentacaoDTO(tipo)).collect(Collectors.toList());
	}
	
}
