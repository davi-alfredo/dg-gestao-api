package com.dg.gestao.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dg.gestao.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

	@Query(value = "SELECT * FROM cliente WHERE situacao_cliente_id=?1", nativeQuery = true )
	List<Cliente> getBySituacao(int idSituacao);

}
