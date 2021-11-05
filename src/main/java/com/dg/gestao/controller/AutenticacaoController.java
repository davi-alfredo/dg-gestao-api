package com.dg.gestao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.dto.ResponseDTO;
import com.dg.gestao.entities.Usuario;
import com.dg.gestao.services.AutenticacaoService;

import io.swagger.v3.oas.annotations.tags.Tag;
import javassist.NotFoundException;

@RestController
@CrossOrigin
@Tag(name="Autenticação API", description = "API Autenticação")
@RequestMapping(value="/api")
public class AutenticacaoController {
	
	@Autowired
	AutenticacaoService service;
	
	@PostMapping(value="/autenticacao")
	public ResponseEntity<?> autenticarUsuario(@RequestBody final Usuario usuario) {
		try {
			service.autenticarUsuario(usuario);
			return new ResponseEntity<>(new ResponseDTO("Autenticado com sucesso."), HttpStatus.OK);
		}catch(NotFoundException e) {			 
			return new ResponseEntity<>(new ResponseDTO("Usuario/Senha invalido(s)."), HttpStatus.UNAUTHORIZED);
		}
	}

}
