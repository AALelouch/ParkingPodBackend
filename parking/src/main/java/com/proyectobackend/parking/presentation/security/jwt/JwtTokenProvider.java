package com.proyectobackend.parking.presentation.security.jwt;

import com.proyectobackend.parking.presentation.security.jwt.exception.ProviderException;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private int jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

    public String getUsernameOfJwt(String token){
        Claims claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;

        }catch (SignatureException e){
            throw new ProviderException(HttpStatus.BAD_REQUEST, "Invalid JWT signature");
        }catch (MalformedJwtException e){
            throw new ProviderException(HttpStatus.BAD_REQUEST, "Invalid JWT token");
        }catch (ExpiredJwtException e){
            throw new ProviderException(HttpStatus.BAD_REQUEST, "Expired JWT token");
        }catch (UnsupportedJwtException e){
            throw new ProviderException(HttpStatus.BAD_REQUEST, "Unsupported JWT token");
        }catch (IllegalArgumentException e){
            throw new ProviderException(HttpStatus.BAD_REQUEST, "JWT claims string is empty");
        }
    }
}
