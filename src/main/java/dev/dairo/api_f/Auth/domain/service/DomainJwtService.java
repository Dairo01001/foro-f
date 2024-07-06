package dev.dairo.api_f.Auth.domain.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class DomainJwtService implements JwtService {

    @Value("${auth.jwt.secret}")
    private String SECRET;

    @Value("${auth.jwt.expiration}")
    private Long EXPIRATION_TIME_IN_MINUTES;

    @Override
    public String extractUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("-05:00"))));
    }

    private Date extractExpirationDate(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    private String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(userDetails.getUsername())
                .issuedAt(Date.from(LocalDateTime.now().toInstant(ZoneOffset.of("-05:00"))))
                .expiration(Date.from(generateExpirationDate(EXPIRATION_TIME_IN_MINUTES)))
                .signWith(getSigningKey())
                .compact();
    }

    private Instant generateExpirationDate(long expirationTimeMinutes) {
        return LocalDateTime
                .now()
                .plusMinutes(expirationTimeMinutes)
                .toInstant(ZoneOffset.of("-05:00"));
    }


    private <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getClaims(String token) {
        return Jwts
                .parser()
                .verifyWith(getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    private SecretKey getSigningKey() {
        byte[] keyBytes = Base64.getDecoder().decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
