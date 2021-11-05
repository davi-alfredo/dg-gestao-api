package com.dg.gestao.dto;

import java.io.Serializable;

import com.dg.gestao.entities.TipoMovimentacao;

public class MovimentacaoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mes;
	private int mesNumerico;
	private double entradas;
	private double saidas;
	private double total;
	private double totalMovimentacao;
	private Integer tipoMovimentacao;
	
	
	public MovimentacaoDTO() {
		
	}
	
	
	public MovimentacaoDTO(String mes, int mesNumerico, double entradas, double saidas, double total) {
		this.mes = mes;
		this.mesNumerico = mesNumerico;
		this.entradas = entradas;
		this.saidas = saidas;
		this.total = total;
	}
	
	public MovimentacaoDTO(TipoMovimentacao tipoMovimentacao, double totalMovimentacao, int mesNumerico) {
		
		this.tipoMovimentacao = tipoMovimentacao.getId();
		this.totalMovimentacao = totalMovimentacao;
		this.mesNumerico = mesNumerico;
		
		
		
	}

	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
		this.mes = mes;
	}
	public double getEntradas() {
		return entradas;
	}
	public void setEntradas(double entradas) {
		this.entradas = entradas;
	}
	public double getSaidas() {
		return saidas;
	}
	public void setSaidas(double saidas) {
		this.saidas = saidas;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getMesNumerico() {
		return mesNumerico;
	}
	public void setMesNumerico(int mesNumerico) {
		this.mesNumerico = mesNumerico;
	}


	public double getTotalMovimentacao() {
		return totalMovimentacao;
	}


	public void setTotalMovimentacao(double totalMovimentacao) {
		this.totalMovimentacao = totalMovimentacao;
	}


	public int getTipoMovimentacao() {
		return tipoMovimentacao;
	}


	public void setTipoMovimentacao(int tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

}


