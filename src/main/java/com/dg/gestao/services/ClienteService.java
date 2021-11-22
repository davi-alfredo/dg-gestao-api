package com.dg.gestao.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.ClienteDTO;
import com.dg.gestao.entities.Cliente;
import com.dg.gestao.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	public ClienteRepository repository;
	
	
	public List<ClienteDTO> findAll() {		
		List<Cliente> result = repository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
		return result.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
	}
	
	public ClienteDTO findById(UUID id) {
		try {
			Cliente cliente = repository.getById(id);
			return new ClienteDTO(cliente);
		}catch(JpaObjectRetrievalFailureException e) {
			throw new EntityNotFoundException("Nenhum registro encontrado para o ID informado.");
		}
	}
	
	public ClienteDTO save(Cliente cliente) {
		return new ClienteDTO(repository.save(cliente));	
	}
	
	public ClienteDTO updateCliente(final Cliente cliente) {
		try {
			repository.existsById(cliente.getId());
			return new ClienteDTO(repository.save(cliente));
		}catch(JpaObjectRetrievalFailureException e) {
			throw new EntityNotFoundException("Nenhum registro encontrado para o ID informado.");
		}
	}

	public Object getBySituacao(int idSituacao) {
		List<Cliente> result = repository.getBySituacao(idSituacao);		
		return result.stream().map(cliente -> new ClienteDTO(cliente)).collect(Collectors.toList());
	}
}
