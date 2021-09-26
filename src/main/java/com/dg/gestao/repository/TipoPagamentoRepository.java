package com.dg.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dg.gestao.model.TipoPagamentoModel;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamentoModel, Integer> {

}
