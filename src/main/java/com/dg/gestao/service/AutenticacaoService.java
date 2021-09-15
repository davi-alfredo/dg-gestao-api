package com.dg.gestao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.gestao.config.EncoderPassword;
import com.dg.gestao.model.UsuarioModel;
import com.dg.gestao.repository.UsuarioRepository;

import javassist.NotFoundException;

@Service
public class AutenticacaoService {
	@Autowired 
	UsuarioRepository repository;

	
	
	
	public void autenticarUsuario(UsuarioModel usuarioRequest) throws NotFoundException {		
		
		UsuarioModel usuario = repository.getUsuarioByEmail(usuarioRequest.getEmail());		
		boolean isValid = EncoderPassword.isPasswordValido(usuarioRequest.getPassword(), usuario.getPassword());
		if(usuario == null || !isValid)
			throw new NotFoundException("Usuário e/ou senha invalidos");
	}	
}
