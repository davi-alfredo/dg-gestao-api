package com.dg.gestao.dto;

import java.io.Serializable;

import com.dg.gestao.entities.SituacaoVeiculo;

public class SituacaoVeiculoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
		
	private Integer id;	
	private String descricao;

	public SituacaoVeiculoDTO() {
		
	}
	public SituacaoVeiculoDTO(SituacaoVeiculo entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
	}
	public SituacaoVeiculoDTO(Integer id, String descricao) {
		super();
		this.id = id;
		this.descricao = descricao;
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
