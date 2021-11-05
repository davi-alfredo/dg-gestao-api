package com.dg.gestao.dto;

public class RetornoMovimentacaoDTO {
	
	private Integer tipoMovimentacao;
	private Double valor;
	
	public Integer getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(Integer tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getMes() {
		return mes;
	}
	public void setMes(Double mes) {
		this.mes = mes;
	}
	private Double mes;
	
	

}
