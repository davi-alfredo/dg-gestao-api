package com.dg.gestao.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dg.gestao.config.EncoderPassword;
import com.dg.gestao.entities.Usuario;
import com.dg.gestao.repositories.UsuarioRepository;

import javassist.NotFoundException;

@Service
public class AutenticacaoService {
	@Autowired 
	UsuarioRepository repository;

	
	
	
	public void autenticarUsuario(Usuario usuarioRequest) throws NotFoundException {		
		
		Usuario usuario = repository.getUsuarioByEmail(usuarioRequest.getEmail());		
		boolean isValid = EncoderPassword.isPasswordValido(usuarioRequest.getPassword(), usuario.getPassword());
		if(usuario == null || !isValid)
			throw new NotFoundException("Usuário e/ou senha invalidos");
	}	
}
