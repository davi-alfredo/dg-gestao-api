package com.dg.gestao.config;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedHeaders(this.ListOf("Authorization, Cache-Control, Content-Type"));
        corsConfiguration.setAllowedOrigins(this.ListOf("*"));
        corsConfiguration.setAllowedMethods(this.ListOf("GET,POST,PUT,DELETE,PUT,OPTIONS,PATCH,DELETE"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setExposedHeaders(this.ListOf("Authorization"));
        
        // You can customize the following part based on your project, it's only a sample
        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest()
                .authenticated().and().csrf().disable().cors().configurationSource(request -> corsConfiguration);

    }
	
	
	private List<String> ListOf(String itens){
		
		String [] arrayItens = itens.split(",");
		List<String> listaItens = new ArrayList<String>();
		
		for (int i = 0; i < arrayItens.length; i++) {
			listaItens.add(arrayItens[i]);
		}		
		return listaItens;
	}
}
