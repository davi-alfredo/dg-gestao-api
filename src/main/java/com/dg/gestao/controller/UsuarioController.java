package com.dg.gestao.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dg.gestao.config.EncoderPassword;
import com.dg.gestao.dto.ResponseDTO;
import com.dg.gestao.dto.UsuarioDTO;
import com.dg.gestao.model.UsuarioModel;
import com.dg.gestao.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin
@Tag(name="Usuários API", description = "API Usuários")
@RequestMapping(value="/api")
public class UsuarioController {
	
	@Autowired 
	UsuarioRepository repository;
	
	@GetMapping(value="/usuarios")
	public ResponseEntity<?> getUsuarios() {		
		return new ResponseEntity<>(this.ListUsuarioModelToDTO(repository.findAll()), HttpStatus.OK);
	}

	@GetMapping(value="/usuarios/{id}")
	public ResponseEntity<?> getUsuaio(@PathVariable UUID id) {
		try {
			return new ResponseEntity<>(new UsuarioDTO(repository.getById(id)), HttpStatus.OK);
		}catch(EntityNotFoundException e) {
			return new ResponseEntity<>(new ResponseDTO("Nenhum registro encontrado para o ID informado."), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping(value="/usuarios")
	public ResponseEntity<?> addUsuario(@RequestBody UsuarioModel usuario) {
		try {
			usuario.setPassword(EncoderPassword.encode(usuario.getPassword()));
			return new ResponseEntity<>(new UsuarioDTO(repository.save(usuario)), HttpStatus.CREATED);
		}catch(org.springframework.dao.DataIntegrityViolationException e) {
			return new ResponseEntity<>(new ResponseDTO("E-mail "+usuario.getEmail() +" ja existe!"), HttpStatus.BAD_REQUEST);
		}
			
	}
	
	
	private List<UsuarioDTO> ListUsuarioModelToDTO(List<UsuarioModel> usuariosModel){
		
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		for (UsuarioModel usuarioModel : usuariosModel) {
			usuariosDTO.add(new UsuarioDTO(usuarioModel));
		}		
		return usuariosDTO;
	}
}
