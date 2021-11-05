package com.dg.gestao.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dg.gestao.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
	
	
	@Query(value = "SELECT * FROM USUARIO WHERE EMAIL=?1", nativeQuery = true )
	Usuario getUsuarioByEmail(String email);

}
