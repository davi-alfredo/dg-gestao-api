package com.dg.gestao.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dg.gestao.entities.Veiculo;

public interface VeiculoRepository extends JpaRepository<Veiculo, UUID> {

	
	@Query(value = "SELECT * FROM veiculo WHERE situacao_veiculo_id=?1", nativeQuery = true )
	List<Veiculo> getBySituacao(int idSituacao);

}
