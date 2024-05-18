package com.ServeSync.backend.Jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuth   extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        final String token = getTokenFromRequest(request);

        if (token==null){
            filterChain.doFilter(request,response);
            return;

        }
        filterChain.doFilter(request,response);
    }



    public String getTokenFromRequest(HttpServletRequest request){

        final String authHeader=request.getHeader(HttpHeaders.AUTHORIZATION);

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer") ){        /*busca en la ruta la palabra bearer y los inicia con la misma */

            return authHeader.substring(7);                      /*se extrae y retorna el token - tambien le digo que apartir del caracter 7 es el token*/

        }

        return authHeader;
    }
}
