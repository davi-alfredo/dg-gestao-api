package com.dg.gestao.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "movimentacao_financeira")
public class MovimentacaoFinanceiraModel implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Id
		@Column(name = "movimentacao_id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id; 
				
		@Column(length = 250, nullable = false)
		private String descricao;

		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="cliente_id")
		@JsonManagedReference(value = "cliente-movimentacao")
		private ClienteModel cliente;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="veiculo_id")
		@JsonManagedReference(value = "veiculo-movimentacao")
		private VeiculoModel veiculo;
		
		@OneToOne
		private TipoMovimentacaoModel tipoMovimentacao;
		
		@OneToOne
		private TipoPagamentoModel tipoPagamento;	
		
		@Column(name="pago")
		private boolean pago;
		
		@Column(name="data_vencimento")
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		@DateTimeFormat(pattern="dd/MM/yyyy")
		private LocalDate dataVencimento;
		
		@Column(name="data_pagamento", nullable = true)
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
		@DateTimeFormat(pattern="dd/MM/yyyy")
		private LocalDate dataPagamento;


		@Column(name = "updated_at")
	    @UpdateTimestamp
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
		private LocalDateTime dataAtualizacao ;
	    
	    @Column(name = "created_at")
	    @UpdateTimestamp
	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
		private LocalDateTime dataCadastro;
	    
		
		public boolean isPago() {
			return pago;
		}

		public void setPago(boolean pago) {
			this.pago = pago;
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

		@Column(name="valor")
		private Double valor;
		
		public ClienteModel getCliente() {
			return cliente;
		}

		public void setCliente(ClienteModel cliente) {
			this.cliente = cliente;
		}

		public VeiculoModel getVeiculo() {
			return veiculo;
		}

		public void setVeiculo(VeiculoModel veiculo) {
			this.veiculo = veiculo;
		}

		public TipoMovimentacaoModel getTipoMovimentacao() {
			return tipoMovimentacao;
		}

		public void setTipoMovimentacao(TipoMovimentacaoModel tipoMovimentacao) {
			this.tipoMovimentacao = tipoMovimentacao;
		}

		public TipoPagamentoModel getTipoPagamento() {
			return tipoPagamento;
		}

		public void setTipoPagamento(TipoPagamentoModel tipoPagamento) {
			this.tipoPagamento = tipoPagamento;
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

		public LocalDateTime getDataCadastro() {
			return dataCadastro;
		}

		public void setDataCadastro(LocalDateTime dataCadastro) {
			this.dataCadastro = dataCadastro;
		}

		public LocalDateTime getDataAtualizacao() {
			return dataAtualizacao;
		}

		public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
			this.dataAtualizacao = dataAtualizacao;
		}
	
	
	

}
