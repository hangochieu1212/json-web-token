package com.example.jwt.jwt;
import org.springframework.security.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    public static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);
    private String mySecret = "hangochieu1212";
    private int jwtExpiration = 86400;

    //create a new token
    public String createToken(Authentication authentication) {
        UserDetails userPrinciple = (UserDetails) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject((userPrinciple.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpiration))
                .signWith(SignatureAlgorithm.HS512, mySecret)
                .compact();
    }
    //Validate token
    public boolean validateJwtToken(String token) {
        try {
            Jwts.parser().setSigningKey(mySecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            throw new RuntimeException("Token không hợp lệ.", e);
        }
    }
    //Get username by token
    public String getUsernameFromJwtToken(String token) {
       String username = Jwts.parser().setSigningKey(mySecret).parseClaimsJws(token).getBody().getSubject();
       return username;
    }
}
