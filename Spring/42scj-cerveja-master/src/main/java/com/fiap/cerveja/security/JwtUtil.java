package com.fiap.cerveja.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expireInSeconds}")
    private int expireInSeconds;

    public String gerarToken(String usuario){
        Date dataCriacao = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
        Date dataExpiracao = Date.from(LocalDateTime.now().plusSeconds(expireInSeconds).toInstant(ZoneOffset.UTC));

        Map<String, Object> claims = new HashMap<>(); // payload
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(dataCriacao)
                .setExpiration(dataExpiracao)
                .setSubject(usuario)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String obterUsuarioDoToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

}
