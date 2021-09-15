package com.dg.gestao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dg.gestao.model.MovimentacaoFinanceiraModel;

public interface MovimentacaoFinanceiraRepository extends JpaRepository<MovimentacaoFinanceiraModel, Long> {

}
