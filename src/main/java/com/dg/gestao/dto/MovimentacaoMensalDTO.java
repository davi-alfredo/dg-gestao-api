package com.dg.gestao.dto;

import java.io.Serializable;

public class MovimentacaoMensalDTO implements Serializable{
	
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
	
	public MovimentacaoMensalDTO() {
		
	}
	
	
	public MovimentacaoMensalDTO(String mes, int mesNumerico, double entradas, double saidas, double total) {
		this.mes = mes;
		this.mesNumerico = mesNumerico;
		this.entradas = entradas;
		this.saidas = saidas;
		this.total = total;
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

}


