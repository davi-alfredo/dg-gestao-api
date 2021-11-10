package com.dg.gestao.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.format.annotation.DateTimeFormat;

import com.dg.gestao.entities.Veiculo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class VeiculoDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	private UUID id;
	private String placa;
	private String fabricante;
	private String modelo;
	private String cor;
	private int anoFabricacao;
	private int anoModelo;
	private Double valorCompra;
	private Double valorVenda;
	private Double valorFIPE;
	private boolean ativo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern="dd/MM/yyyy")	
	private LocalDate dataCompra;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern="dd/MM/yyyy")	
	private LocalDate dataVenda;
	private String renavam;
	private String urlImagem;

	
	public VeiculoDTO() {
			
	}


	public VeiculoDTO(Veiculo entity) {
		this.id = entity.getId();
		this.placa = entity.getPlaca();
		this.fabricante = entity.getFabricante();
		this.modelo = entity.getModelo();
		this.cor = entity.getCor();
		this.anoFabricacao = entity.getAnoFabricacao();
		this.anoModelo = entity.getAnoModelo();
		this.valorCompra = entity.getValorCompra();
		this.valorVenda = entity.getValorVenda();
		this.valorFIPE = entity.getValorFIPE();
		this.ativo = entity.getAtivo();
		this.dataCompra = entity.getDataCompra();
		this.dataVenda = entity.getDataVenda();
		this.renavam = entity.getRenavam();
		this.urlImagem = entity.getUrlImagem();
	}


	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getFabricante() {
		return fabricante;
	}


	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getCor() {
		return cor;
	}


	public void setCor(String cor) {
		this.cor = cor;
	}


	public int getAnoFabricacao() {
		return anoFabricacao;
	}


	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}


	public int getAnoModelo() {
		return anoModelo;
	}


	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}


	public Double getValorCompra() {
		return valorCompra;
	}


	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}


	public Double getValorVenda() {
		return valorVenda;
	}


	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}


	public Double getValorFIPE() {
		return valorFIPE;
	}


	public void setValorFIPE(Double valorFIPE) {
		this.valorFIPE = valorFIPE;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


	public LocalDate getDataCompra() {
		return dataCompra;
	}


	public void setDataCompra(LocalDate dataCompra) {
		this.dataCompra = dataCompra;
	}


	public LocalDate getDataVenda() {
		return dataVenda;
	}


	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}


	public String getRenavam() {
		return renavam;
	}


	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}


	public String getUrlImagem() {
		return urlImagem;
	}


	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}

	
}
