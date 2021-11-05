package com.dg.gestao.dto;

import java.io.Serializable;

import com.dg.gestao.entities.SituacaoCliente;

public class SituacaoClienteDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;	
	private String descricao;

	public SituacaoClienteDTO() {
		
	}
	
	public SituacaoClienteDTO(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
	}
	
	public SituacaoClienteDTO(SituacaoCliente entity) {
		
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
}
