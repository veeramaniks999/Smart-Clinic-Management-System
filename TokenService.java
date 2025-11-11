// TokenService.java
// Smart Clinic Management System
// Author: <Your Name>
// Description: Handles token generation and validation (mock service).

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenService {
    private Map<String, String> tokenStore = new HashMap<>();

    // Generate token for a username
    public String generateToken(String username) {
        String token = UUID.randomUUID().toString();
        tokenStore.put(token, username);
        System.out.println("Generated token for user: " + username);
        return token;
    }

    // Validate token
    public boolean validateToken(String token) {
        boolean valid = tokenStore.containsKey(token);
        if (valid) {
            System.out.println("Token is valid for user: " + tokenStore.get(token));
        } else {
            System.out.println("Invalid or expired token.");
        }
        return valid;
    }

    // Revoke token
    public void revokeToken(String token) {
        tokenStore.remove(token);
        System.out.println("Token revoked successfully.");
    }
}
