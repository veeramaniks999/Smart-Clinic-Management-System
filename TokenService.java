package com.smartclinic.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class TokenService {

    // ✅ Secret key for signing the JWT (should be kept private)
    private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // ✅ Token validity: 1 hour (in milliseconds)
    private static final long EXPIRATION_TIME = 3600000; // 1 hour

    /**
     * Generates a JWT token for the given email address.
     *
     * @param email the user's email address
     * @return the generated JWT token
     */
    public String generateToken(String email) {
        long currentTimeMillis = System.currentTimeMillis();
        Date issuedAt = new Date(currentTimeMillis);
        Date expiration = new Date(currentTimeMillis + EXPIRATION_TIME);

        // ✅ Build the JWT using Jwts.builder()
        return Jwts.builder()
                .setSubject(email) // Include email in the token
                .setIssuedAt(issuedAt) // Token issue time
                .setExpiration(expiration) // Token expiry time
                .signWith(SECRET_KEY) // Sign with secret key
                .compact();
    }

    /**
     * Validates the token (optional helper method).
     *
     * @param token the JWT token to validate
     * @return true if valid, false otherwise
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
