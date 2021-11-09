package com.dg.gestao.dto;

import java.io.Serializable;

import com.dg.gestao.entities.TipoMovimentacao;

public class SumMovimentacaoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int mes;
	private double total;
	private Integer tipoMovimentacao;
	
	
	public SumMovimentacaoDTO() {
		
	}
		
	public SumMovimentacaoDTO(TipoMovimentacao tipoMovimentacao, double total, int mes) {
		
		this.tipoMovimentacao = tipoMovimentacao.getId();
		this.setTotal(total);
		this.mes = mes;	
		
	}
	
	public SumMovimentacaoDTO(TipoMovimentacao tipoMovimentacao, double total) {
		this.tipoMovimentacao = tipoMovimentacao.getId();
		this.setTotal(total);	
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public Integer getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(Integer tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	
}


