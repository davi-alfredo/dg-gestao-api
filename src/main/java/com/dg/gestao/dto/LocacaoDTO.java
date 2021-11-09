package com.dg.gestao.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.dg.gestao.entities.Locacao;

public class LocacaoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UUID id;
	private VeiculoDTO veiculo;
	private ClienteDTO cliente;
	private boolean ativo;
	private LocalDate dataInicio;
	private LocalDate dataTermino;
	private String observacao;
	private Double valor;
	
	public LocacaoDTO() {
		
	}

	public LocacaoDTO(Locacao entity) {
		id = entity.getId();
		veiculo = new VeiculoDTO(entity.getVeiculo());
		cliente = new ClienteDTO(entity.getCliente());
		ativo = entity.isAtivo();
		dataInicio = entity.getDataInicio();
		dataTermino = entity.getDataTermino();
		observacao = entity.getObservacao();
		valor = entity.getValor();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public VeiculoDTO getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(LocalDate dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
}
