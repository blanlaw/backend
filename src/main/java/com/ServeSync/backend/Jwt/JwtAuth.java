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

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer") ){        /*ruta bearer/

            return authHeader.substring(7);                      /*rturn tk*/

        }

        return authHeader;
    }
}
