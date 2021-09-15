package com.dg.gestao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dg.gestao.model.VeiculoModel;

public interface VeiculoRepository extends JpaRepository<VeiculoModel, UUID> {

}
