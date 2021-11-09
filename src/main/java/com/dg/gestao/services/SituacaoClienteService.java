package com.dg.gestao.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.SituacaoClienteDTO;
import com.dg.gestao.entities.SituacaoCliente;
import com.dg.gestao.repositories.SituacaoClienteRepository;

@Service
public class SituacaoClienteService {
	
	@Autowired
	public SituacaoClienteRepository repository;
	
	
	public List<SituacaoClienteDTO> findAll() {		
		List<SituacaoCliente> result = repository.findAll();
		return result.stream().map(situacao -> new SituacaoClienteDTO(situacao)).collect(Collectors.toList());
	}
	
}
