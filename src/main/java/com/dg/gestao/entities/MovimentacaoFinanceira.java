package com.dg.gestao.entities;

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


@Entity
@Table(name = "movimentacao_financeira")
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, 
//property  = "movimentacao_id", scope     = Long.class)
public class MovimentacaoFinanceira implements Serializable{

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
		//@JsonManagedReference//(value = "cliente-movimentacoes")
		private Cliente cliente;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="veiculo_id")
		//@JsonManagedReference//(value = "veiculo-movimentacoes")
		private Veiculo veiculo;
		
		@OneToOne
		private TipoMovimentacao tipoMovimentacao;
		
		@OneToOne
		private TipoPagamento tipoPagamento;	
		
		@OneToOne
		private SituacaoPagamento situacaoPagamento;	
						
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

	    @Column(name="valor")
		private Double valor;
	    
	    @Column(name="valor_pago")
		private Double valorPago;
	    
	    
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
		
		public Cliente getCliente() {
			return cliente;
		}

		public void setCliente(Cliente cliente) {
			this.cliente = cliente;
		}

		public Veiculo getVeiculo() {
			return veiculo;
		}

		public void setVeiculo(Veiculo veiculo) {
			this.veiculo = veiculo;
		}

		public TipoMovimentacao getTipoMovimentacao() {
			return tipoMovimentacao;
		}

		public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
			this.tipoMovimentacao = tipoMovimentacao;
		}

		public TipoPagamento getTipoPagamento() {
			return tipoPagamento;
		}

		public void setTipoPagamento(TipoPagamento tipoPagamento) {
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

		public SituacaoPagamento getSituacaoPagamento() {
			return situacaoPagamento;
		}

		public void setSituacaoPagamento(SituacaoPagamento situacaoPagamento) {
			this.situacaoPagamento = situacaoPagamento;
		}

		public Double getValorPago() {
			return valorPago;
		}

		public void setValorPago(Double valorPago) {
			this.valorPago = valorPago;
		}
	
}
