package com.dg.gestao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.SituacaoVeiculoDTO;
import com.dg.gestao.entities.SituacaoVeiculo;
import com.dg.gestao.repositories.SituacaoVeiculoRepository;

@Service
public class SituacaoVeiculoService {
	
	@Autowired
	public SituacaoVeiculoRepository repository;
	
	
	public List<SituacaoVeiculoDTO> findAll() {		
		List<SituacaoVeiculo> result = repository.findAll();
		return result.stream().map(situacao -> new SituacaoVeiculoDTO(situacao)).collect(Collectors.toList());
	}
	
}
