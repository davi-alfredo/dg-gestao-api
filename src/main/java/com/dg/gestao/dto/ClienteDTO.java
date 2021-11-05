package com.dg.gestao.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.dg.gestao.entities.Cliente;
import com.dg.gestao.entities.SituacaoCliente;

public class ClienteDTO implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UUID id;	
	private String nome;
	private String apelido;private String rg;
	private String cpf;
	private LocalDate dataNascimento;
	private String endereco;
	private String bairro;
	private String cidade;
	private String uf;
	private String telefone;	
	private String email;	
	private SituacaoCliente situacaoCliente;
	private String urlImagem;
	
	
	public ClienteDTO() {
		
	}


	public ClienteDTO(Cliente entity) {		
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.apelido = entity.getApelido();
		this.rg = entity.getRg();
		this.cpf = entity.getCpf();
		this.dataNascimento = entity.getDataNascimento();
		this.endereco = entity.getEndereco();
		this.bairro = entity.getBairro();
		this.cidade = entity.getCidade();
		this.uf = entity.getUf();
		this.telefone = entity.getTelefone();
		this.email = entity.getEmail();
		this.situacaoCliente = entity.getSituacaoCliente();		
		this.urlImagem = entity.getUrlImagem();
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


	public String getApelido() {
		return apelido;
	}


	public void setApelido(String apelido) {
		this.apelido = apelido;
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


	public SituacaoCliente getSituacaoCliente() {
		return situacaoCliente;
	}


	public void setSituacaoCliente(SituacaoCliente situacaoCliente) {
		this.situacaoCliente = situacaoCliente;
	}


	public String getUrlImagem() {
		return urlImagem;
	}


	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}	
	
}
