package com.fiap.cerveja.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private static final String BEARER = "Bearer ";
    private Logger logger = Logger.getLogger(JwtRequestFilter.class.getName());

    private JwtUtil jwtUtil;
    private JwtUserDetailsService jwtUserDetailsService;

    public JwtRequestFilter(JwtUtil jwtUtil, JwtUserDetailsService jwtUserDetailsService) {
        this.jwtUtil = jwtUtil;
        this.jwtUserDetailsService = jwtUserDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        final String token = request.getHeader(HttpHeaders.AUTHORIZATION); // Bearer jwtToken
        String nome = null;
        String jwtToken;

        if (token != null && token.startsWith(BEARER)) {
            jwtToken = token.replace(BEARER, "");
            try {
                nome = jwtUtil.obterUsuarioDoToken(jwtToken);
            } catch (IllegalArgumentException e) {
                logger.info("Error ao fazer o parse do Token: " + e.getMessage());
            } catch (ExpiredJwtException e) {
                logger.info("Token expirado");
            }
        } else {
            logger.info("Token inexistente ou fora do padrão Bearer");
        }

        if(nome != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(nome);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response);
    }
}
