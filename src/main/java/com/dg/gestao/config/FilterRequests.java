package com.dg.gestao.config;

import java.io.IOException;

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



@Component
@Order(1)
public class FilterRequests implements Filter{

	 
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
		
        if(path.startsWith("/api") == false){
            chain.doFilter(request, novoResponse);
            return;
        }
		
		
		String token = req.getHeader("Token");
		
		if(req.getHeader("Token") != null && FirebaseAuthenticationProvider.tokenIsValid(token)) {
			chain.doFilter(request, novoResponse);			
		}else {			
            String error = "Invalid API KEY";

            novoResponse.reset();
            novoResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            novoResponse.setContentLength(error.length());            
            novoResponse.getWriter().write(error);
		}	
		
	}
	
	@Override	   
	public void init(FilterConfig filterconfig) throws ServletException {}

}
