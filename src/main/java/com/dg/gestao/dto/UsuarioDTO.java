package com.dg.gestao.dto;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.dg.gestao.entities.Usuario;

public class UsuarioDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuario_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(unique = true, nullable = false, length = 100)
	private String email;
	
	
	public UsuarioDTO(Usuario usuarioModel) {		
		this.id = usuarioModel.getId();
		this.email = usuarioModel.getEmail();		
	}
	
	
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
