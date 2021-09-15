package com.dg.gestao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dg.gestao.model.LocacaoModel;

public interface LocacaoRepository extends JpaRepository<LocacaoModel, UUID> {

}
