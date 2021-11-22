package com.dg.gestao.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.dg.gestao.entities.ClienteEspera;
import com.dg.gestao.entities.SituacaoCliente;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteEsperaDTO implements Serializable {	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;	
	private String nome;	

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern="dd/MM/yyyy")	
	private LocalDateTime dataCadastro;
	private String telefone;	
	private SituacaoCliente situacaoCliente;
	
	
	public ClienteEsperaDTO() {
		
	}


	public ClienteEsperaDTO(ClienteEspera entity) {		
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.telefone = entity.getTelefone();
		this.situacaoCliente = entity.getSituacaoCliente();		
		this.dataCadastro = entity.getDataCadastro();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}



	public SituacaoCliente getSituacaoCliente() {
		return situacaoCliente;
	}


	public void setSituacaoCliente(SituacaoCliente situacaoCliente) {
		this.situacaoCliente = situacaoCliente;
	}


	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}


	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}