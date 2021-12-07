package br.gov.sp.fatec.bibliotecaOnline.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

public class JwtAutheticationFilter extends GenericFilterBean{
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
           HttpServletRequest httpRequest = (HttpServletRequest) request;
           String autorization = httpRequest.getHeader(HttpHeaders.AUTHORIZATION);
           if(autorization != null) {
               System.out.println("AUTORIZAÇÂO");
               Authentication credentials = JwtUtils.parseToken(autorization.replaceAll("Bearer ", ""));
               SecurityContextHolder.getContext().setAuthentication(credentials);
           }
           System.out.println("SEM AUTORIZAÇÂO");

           chain.doFilter(request, response);
        } catch (Throwable e) {
            System.out.println(e.getMessage());
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, e.getMessage());
        }
    }
}
