package com.dg.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.model.Response;
import com.dg.gestao.model.UsuarioModel;
import com.dg.gestao.service.AutenticacaoService;

import io.swagger.annotations.Api;
import javassist.NotFoundException;

@RestController
@Api("Api Autenticacao")
@RequestMapping(value="/api")
public class AutenticacaoController {
	
	@Autowired
	AutenticacaoService service;
	
	@PostMapping(value="/autenticacao")
	public ResponseEntity<?> autenticarUsuario(@RequestBody final UsuarioModel usuario) {
		try {
			service.autenticarUsuario(usuario);
			return new ResponseEntity<>(new Response("Autenticado com sucesso."), HttpStatus.OK);
		}catch(NotFoundException e) {			 
			return new ResponseEntity<>(new Response("Usuario/Senha invalido(s)."), HttpStatus.UNAUTHORIZED);
		}
	}

}
