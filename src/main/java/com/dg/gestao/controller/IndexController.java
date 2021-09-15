package com.dg.gestao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Controller
@Api("Pagina Inicial")
@RequestMapping(value="/api")
public class IndexController {
	
	@RequestMapping(value="/")
	public String index() {
		return "index";
	}

}
