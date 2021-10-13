package com.dg.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dg.gestao.model.TipoMovimentacaoModel;

public interface SituacaoPagamentoRepository extends JpaRepository<TipoMovimentacaoModel, Integer> {

}
