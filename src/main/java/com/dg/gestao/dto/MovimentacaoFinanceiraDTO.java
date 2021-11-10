package com.dg.gestao.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.dg.gestao.entities.MovimentacaoFinanceira;
import com.fasterxml.jackson.annotation.JsonFormat;

public class MovimentacaoFinanceiraDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	private Long id;
	private String descricao;	
	private ClienteDTO cliente;	
	private VeiculoDTO veiculo;	
	private TipoMovimentacaoDTO tipoMovimentacao;	
	private TipoPagamentoDTO tipoPagamento;		
	private SituacaoPagamentoDTO situacaoPagamento;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern="dd/MM/yyyy")	
	private LocalDate dataVencimento;	
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate dataPagamento;
	
	private Double valor;
	private Double valorPago;
	
	
	public MovimentacaoFinanceiraDTO() {
		
	}	
	
	
	public MovimentacaoFinanceiraDTO(MovimentacaoFinanceira entity) {
		this.id = entity.getId();
		this.descricao = entity.getDescricao();
		this.cliente = new ClienteDTO(entity.getCliente());
		this.veiculo = new VeiculoDTO(entity.getVeiculo());
		this.tipoMovimentacao = new TipoMovimentacaoDTO(entity.getTipoMovimentacao());
		this.tipoPagamento = new TipoPagamentoDTO(entity.getTipoPagamento());
		this.situacaoPagamento = new SituacaoPagamentoDTO(entity.getSituacaoPagamento());
		this.dataVencimento = entity.getDataVencimento();
		this.dataPagamento = entity.getDataPagamento();
		this.valor = entity.getValor();
		this.valorPago = entity.getValorPago();
	}



	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public ClienteDTO getCliente() {
		return cliente;
	}
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	public VeiculoDTO getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(VeiculoDTO veiculo) {
		this.veiculo = veiculo;
	}
	public TipoMovimentacaoDTO getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(TipoMovimentacaoDTO tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	public TipoPagamentoDTO getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamentoDTO tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	public SituacaoPagamentoDTO getSituacaoPagamento() {
		return situacaoPagamento;
	}
	public void setSituacaoPagamento(SituacaoPagamentoDTO situacaoPagamento) {
		this.situacaoPagamento = situacaoPagamento;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public LocalDate getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

}
