package com.dg.gestao.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dg.gestao.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {

	@Query(value = "SELECT * FROM cliente WHERE ativo=?1", nativeQuery = true )
	List<ClienteModel> getBySituacao(int idSituacao);

}
