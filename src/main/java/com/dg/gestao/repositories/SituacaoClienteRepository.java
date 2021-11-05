package com.dg.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dg.gestao.entities.SituacaoCliente;

public interface SituacaoClienteRepository extends JpaRepository<SituacaoCliente, Integer> {

}
