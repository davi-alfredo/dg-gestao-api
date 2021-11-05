package com.dg.gestao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dg.gestao.entities.TipoPagamento;

public interface TipoPagamentoRepository extends JpaRepository<TipoPagamento, Integer> {

}
