package com.dashi.gymtracker.service.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String getToken(UserDetails userDetails);
    String getUsernameFromToken(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
}
