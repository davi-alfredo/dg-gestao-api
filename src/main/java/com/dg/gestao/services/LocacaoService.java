package com.dg.gestao.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.LocacaoDTO;
import com.dg.gestao.entities.Locacao;
import com.dg.gestao.repositories.LocacaoRepository;

@Service
public class LocacaoService {
	
	@Autowired
	public LocacaoRepository repository;
	
	
	public List<LocacaoDTO> findAll() {		
		List<Locacao> result = repository.findAll(Sort.by(Sort.Direction.ASC, "dataInicio"));
		return result.stream().map(locacao -> new LocacaoDTO(locacao)).collect(Collectors.toList());
	}
	
	public LocacaoDTO getById(UUID id) {
		try {
			Locacao locacao = repository.getById(id);
			return new LocacaoDTO(locacao);
		}catch(JpaObjectRetrievalFailureException e) {
			throw new EntityNotFoundException("Nenhum registro encontrado para o ID informado.");
		}
	}
	
	public LocacaoDTO save(Locacao veiculo) {
		return new LocacaoDTO(repository.save(veiculo));	
	}
	
	public LocacaoDTO updateLocacao(final Locacao veiculo) {
		try {
			repository.existsById(veiculo.getId());
			return new LocacaoDTO(repository.save(veiculo));
		}catch(JpaObjectRetrievalFailureException e) {
			throw new EntityNotFoundException("Nenhum registro encontrado para o ID informado.");
		}
	}	
}
