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
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="rg")
	private String rg;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="data_nascimento")
	private LocalDate dataNascimento;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="uf")
	private String uf;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="email")
	private String email;
	
	@Column(name="ativo")
	private boolean ativo;
	
	@Column(name="data_cadastro")
	private LocalDate data_cadastro;
	
	@Column(name="data_atualizacao")
	private LocalDate data_atualizacao;

	@Column(name="url_imagem")
	private String urlImagem;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")	
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

	public LocalDate getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(LocalDate data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public LocalDate getData_atualizacao() {
		return data_atualizacao;
	}

	public void setData_atualizacao(LocalDate data_atualizacao) {
		this.data_atualizacao = data_atualizacao;
	}

	public List<MovimentacaoFinanceiraModel> getMovimentacoesFinanceiras() {
		return movimentacoesFinanceiras;
	}
	
	public void setMovimentacoesFinanceiras(List<MovimentacaoFinanceiraModel> movimentacoesFinanceiras) {
		this.movimentacoesFinanceiras = movimentacoesFinanceiras;
	}
	
	
	

}
