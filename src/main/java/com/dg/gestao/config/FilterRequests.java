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



//@Component
//@Order(1)
public class FilterRequests implements Filter{

	 
	public void destroy() {}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	    
		HttpServletRequest req = (HttpServletRequest) request;		
		String path = req.getRequestURI();

        if(path.startsWith("/api") == false){
            chain.doFilter(request, response);
            return;
        }
		
		
		String token = req.getHeader("Token");
		
		if(req.getHeader("Token") != null && FirebaseAuthenticationProvider.tokenIsValid(token)) {
			chain.doFilter(request, response);			
		}else {
			HttpServletResponse resp = (HttpServletResponse) response;
            String error = "Invalid API KEY";

            resp.reset();
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentLength(error.length());            
            response.getWriter().write(error);
		}	
		
	}
	
	@Override	   
	public void init(FilterConfig filterconfig) throws ServletException {}

}
