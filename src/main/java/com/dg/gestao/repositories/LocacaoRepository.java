package com.dg.gestao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dg.gestao.entities.Locacao;

public interface LocacaoRepository extends JpaRepository<Locacao, UUID> {

}
