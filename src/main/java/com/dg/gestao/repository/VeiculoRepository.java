package com.dg.gestao.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dg.gestao.model.VeiculoModel;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, UUID> {

	
	@Query(value = "SELECT * FROM veiculo WHERE ativo=?1", nativeQuery = true )
	List<VeiculoModel> getBySituacao(boolean alugado);

}
