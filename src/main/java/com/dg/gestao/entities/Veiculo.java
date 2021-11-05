package com.dg.gestao.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "veiculo")
//@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, 
//property  = "veiculo_id", 
//scope     = UUID.class)
public class Veiculo{
	
	@Id
	@Column(name="veiculo_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name="placa", length = 10, nullable = false)
	private String placa;
	
	@Column(name="fabricante", length = 50, nullable = false)
	private String fabricante;
	
	@Column(name="modelo", length = 100, nullable = false)
	private String modelo;
	
	@Column(name="cor", length = 50, nullable = false)
	private String cor;
	
	@Column(name="ano_fabricacao", nullable = false)
	private int anoFabricacao;
	
	@Column(name="ano_modelo", nullable = false)
	private int anoModelo;
	
	@Column(name="valor_compra", nullable = false)
	private Double valorCompra;
	
	@Column(name="valor_venda", nullable = true)
	private Double valorVenda;
	
	@Column(name="valor_fipe",nullable = false)
	private Double valorFIPE;
	
	@Column
	private boolean ativo;
	
	@Column(name="data_compra", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate dataCompra;

	@Column(name="data_venda", nullable = true)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate dataVenda;

	@Column(name="renavam", length = 50, nullable = true)
	private String renavam;
	
    @Column(name = "updated_at")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataAtualizacao ;
    
    @Column(name = "created_at")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataCriacao ;


	@Column(name="url_imagem")
	private String urlImagem;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "veiculo")
	//@JsonBackReference//(value = "veiculo-movimentacoes")
	@JsonIgnore
	private List<MovimentacaoFinanceira> movimentacoesFinanceiras;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "veiculo")	
	//@JsonBackReference//(value = "cliente-locacoes")
	@JsonIgnore
	private List<Locacao> locacoes;
	
	@OneToOne
	private SituacaoVeiculo situacaoVeiculo;
	
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

	public List<MovimentacaoFinanceira> getMovimentacoesFinanceiras() {
		return movimentacoesFinanceiras;
	}

	public void setMovimentacoesFinanceiras(List<MovimentacaoFinanceira> movimentacoesFinanceiras) {
		this.movimentacoesFinanceiras = movimentacoesFinanceiras;
	}

	public LocalDateTime getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public List<Locacao> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<Locacao> locacoes) {
		this.locacoes = locacoes;
	}

	public SituacaoVeiculo getSituacaoVeiculo() {
		return situacaoVeiculo;
	}

	public void setSituacaoVeiculo(SituacaoVeiculo situacaoVeiculo) {
		this.situacaoVeiculo = situacaoVeiculo;
	}
	
}
