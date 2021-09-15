package com.dg.gestao.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "veiculo")
public class VeiculoModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="veiculo_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name="placa")
	private String placa;
	
	@Column(name="fabricante")
	private String fabricante;
	
	@Column(name="modelo")
	private String modelo;
	
	@Column(name="ano_fabricacao")
	private int anoFabricacao;
	
	@Column(name="ano_modelo")
	private int anoModelo;
	
	@Column(name="valor_compra")
	private Double valorCompra;
	
	@Column(name="valor_venda")
	private Double valorVenda;
	
	@Column(name="valor_fipe")
	private Double valorFIPE;
	
	@Column
	private boolean ativo;
	
	@Column(name="data_compra")
	private LocalDate dataCompra;
	
	@Column(name="data_venda", nullable = true)
	private LocalDate dataVenda;

	@Column(name="url_imagem")
	private String urlImagem;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "veiculo")	
	private List<MovimentacaoFinanceiraModel> movimentacoesFinanceiras;
	
	public String getUrlImagem() {
		return urlImagem;
	}

	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
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

	public Double getValorFIPE() {
		return valorFIPE;
	}

	public void setValorFIPE(Double valorFIPE) {
		this.valorFIPE = valorFIPE;
	}

	public boolean getAtivo() {
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public List<MovimentacaoFinanceiraModel> getMovimentacoesFinanceiras() {
		return movimentacoesFinanceiras;
	}

	public void setMovimentacoesFinanceiras(List<MovimentacaoFinanceiraModel> movimentacoesFinanceiras) {
		this.movimentacoesFinanceiras = movimentacoesFinanceiras;
	}
	
}
