package com.dg.gestao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dg.gestao.model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, UUID> {

}
