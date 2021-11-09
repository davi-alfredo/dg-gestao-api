package com.dg.gestao.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import com.dg.gestao.dto.VeiculoDTO;
import com.dg.gestao.entities.Veiculo;
import com.dg.gestao.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	public VeiculoRepository repository;
	
	
	public List<VeiculoDTO> findAll() {		
		List<Veiculo> result = repository.findAll(Sort.by(Sort.Direction.ASC, "dataCompra"));
		return result.stream().map(veiculo -> new VeiculoDTO(veiculo)).collect(Collectors.toList());
	}
	
	public VeiculoDTO findById(UUID id) {
		try {
			Veiculo veiculo = repository.getById(id);
			return new VeiculoDTO(veiculo);
		}catch(JpaObjectRetrievalFailureException e) {
			throw new EntityNotFoundException("Nenhum registro encontrado para o ID informado.");
		}
	}
	
	public VeiculoDTO save(Veiculo veiculo) {
		return new VeiculoDTO(repository.save(veiculo));	
	}
	
	public VeiculoDTO updateVeiculo(final Veiculo veiculo) {
		try {
			repository.existsById(veiculo.getId());
			return new VeiculoDTO(repository.save(veiculo));
		}catch(JpaObjectRetrievalFailureException e) {
			throw new EntityNotFoundException("Nenhum registro encontrado para o ID informado.");
		}
	}

	public Object getBySituacao(int idSituacao) {
		List<Veiculo> result = repository.getBySituacao(idSituacao);		
		return result.stream().map(veiculo -> new VeiculoDTO(veiculo)).collect(Collectors.toList());
	}
}
