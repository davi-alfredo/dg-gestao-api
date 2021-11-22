package com.dg.gestao.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.ClienteEsperaDTO;
import com.dg.gestao.entities.ClienteEspera;
import com.dg.gestao.repositories.ClienteEsperaRepository;


@Service
public class ClienteEsperaService {
	
	@Autowired
	public ClienteEsperaRepository repository;
	
	
	public List<ClienteEsperaDTO> findAll() {		
		List<ClienteEspera> result = repository.findAll(Sort.by(Sort.Direction.ASC, "dataCadastro"));
		return result.stream().map(cliente -> new ClienteEsperaDTO(cliente)).collect(Collectors.toList());
	}
	
	public ClienteEsperaDTO findById(Integer id) {
		try {
			ClienteEspera cliente = repository.getById(id);
			return new ClienteEsperaDTO(cliente);
		}catch(JpaObjectRetrievalFailureException e) {
			throw new EntityNotFoundException("Nenhum registro encontrado para o ID informado.");
		}
	}
	
	public ClienteEsperaDTO save(ClienteEspera cliente) {
		return new ClienteEsperaDTO(repository.save(cliente));	
	}
	
	public ClienteEsperaDTO updateClienteEspera(final ClienteEspera cliente) {
		try {
			repository.existsById(cliente.getId());
			return new ClienteEsperaDTO(repository.save(cliente));
		}catch(JpaObjectRetrievalFailureException e) {
			throw new EntityNotFoundException("Nenhum registro encontrado para o ID informado.");
		}
	}
}
