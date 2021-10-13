package com.dg.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dg.gestao.model.SituacaoClienteModel;

public interface SituacaoClienteRepository extends JpaRepository<SituacaoClienteModel, Integer> {

}
