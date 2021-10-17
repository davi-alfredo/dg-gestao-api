package com.dg.gestao.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.dg.gestao.dto.ResponseDTO;
import com.google.gson.Gson;



@Component
@Order(1)
public class FilterRequests implements Filter{

	 
    private Gson gson = new Gson();

	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI();
		
		HttpServletResponse novoResponse = (HttpServletResponse) response;
		novoResponse.addHeader("Access-Control-Allow-Origin", "*");
		novoResponse.addHeader("Access-Control-Allow-Headers", "origin, Content-Type, Accept, authorization");
		novoResponse.addHeader("Access-Control-Allow-Credentials", "true");
		novoResponse.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		
		System.out.println("####### PASSOU AQUI 1 #########");
        if(path.startsWith("/api") == false){
            chain.doFilter(request, novoResponse);
            return;
        }
		
		
		String token = req.getHeader("Token");
		
		if(req.getHeader("Token") != null && FirebaseAuthenticationProvider.tokenIsValid(token)) {
			System.out.println("####### PASSOU AQUI 2 #########");
			chain.doFilter(request, novoResponse);
			System.out.println("####### PASSOU AQUI 3 #########");

		}else {			
			System.out.println("####### PASSOU AQUI 4 #########");

			ResponseDTO respDto = new ResponseDTO("Invalid API KEY"); 
			
            novoResponse.reset();
            novoResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);    
            PrintWriter out = response.getWriter();
            novoResponse.setContentType("application/json");
            novoResponse.setCharacterEncoding("UTF-8");
            out.print(this.gson.toJson(respDto));
            out.flush();
    		System.out.println("####### PASSOU AQUI 5 #########");


		}	
		
	}
	
	@Override	   
	public void init(FilterConfig filterconfig) throws ServletException {}

}
