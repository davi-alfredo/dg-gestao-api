package com.dg.gestao.model;

import java.io.Serializable;
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
import javax.persistence.Table;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "cliente")
public class ClienteModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cliente_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(name="nome", length = 150, nullable = false)
	private String nome;
	
	@Column(name="rg", length = 20, nullable = false)
	private String rg;
	
	@Column(name="cpf", length = 20, nullable = false)
	private String cpf;
	
	@Column(name="data_nascimento", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@Column(name="endereco",length = 200, nullable = false)
	private String endereco;
	
	@Column(name="bairro", length = 100, nullable = false)
	private String bairro;
	
	@Column(name="cidade", length = 50, nullable = false)
	private String cidade;
	
	@Column(name="uf", length = 2, nullable = false)
	private String uf;
	
	@Column(name="telefone", length = 20, nullable = false)
	private String telefone;
	
	@Column(name="email", length = 70, nullable = false)
	private String email;
	
	@Column(name="ativo")
	private boolean ativo;
	
	@Column(name = "updated_at")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataAtualizacao ;
    
    @Column(name = "created_at")
    @UpdateTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataCadastro;

    @Column(name="url_imagem", length = 200, nullable = true)
	private String urlImagem;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")	
	//@JsonManagedReference
	@JsonBackReference
	private List<MovimentacaoFinanceiraModel> movimentacoesFinanceiras;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")	
	@JsonBackReference
	private List<LocacaoModel> locacoes;
	
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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

	public List<MovimentacaoFinanceiraModel> getMovimentacoesFinanceiras() {
		return movimentacoesFinanceiras;
	}
	
	public void setMovimentacoesFinanceiras(List<MovimentacaoFinanceiraModel> movimentacoesFinanceiras) {
		this.movimentacoesFinanceiras = movimentacoesFinanceiras;
	}

	public List<LocacaoModel> getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(List<LocacaoModel> locacoes) {
		this.locacoes = locacoes;
	}

}
