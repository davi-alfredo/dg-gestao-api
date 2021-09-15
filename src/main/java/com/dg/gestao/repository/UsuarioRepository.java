package com.dg.gestao.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dg.gestao.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, UUID> {
	
	
	@Query(value = "SELECT * FROM USUARIO WHERE EMAIL=?1", nativeQuery = true )
	UsuarioModel getUsuarioByEmail(String email);

}
