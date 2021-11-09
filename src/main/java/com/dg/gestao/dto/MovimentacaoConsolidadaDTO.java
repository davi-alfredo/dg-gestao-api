package com.dg.gestao.dto;

import java.io.Serializable;
import java.util.List;

public class MovimentacaoConsolidadaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Double totalEntradas;
	private Double totalSaidas;
	private Double total;		
	private List<MovimentacaoMensalDTO> movimentacoesMensais;

	
	public MovimentacaoConsolidadaDTO() {
		totalEntradas = 0d;
		totalSaidas = 0d;
		total = 0d;
	}
	

	public Double getTotalEntradas() {
		return totalEntradas;
	}

	public void setTotalEntradas(Double totalEntradas) {
		this.totalEntradas = totalEntradas;
	}

	public Double getTotalSaidas() {
		return totalSaidas;
	}

	public void setTotalSaidas(Double totalSaidas) {
		this.totalSaidas = totalSaidas;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<MovimentacaoMensalDTO> getMovimentacoesMensais() {
		return movimentacoesMensais;
	}

	public void setMovimentacoesMensais(List<MovimentacaoMensalDTO> movimentacoesMensais) {
		this.movimentacoesMensais = movimentacoesMensais;
	}
	

	
}
