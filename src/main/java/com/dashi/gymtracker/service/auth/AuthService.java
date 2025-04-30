package com.dashi.gymtracker.service.auth;

import com.dashi.gymtracker.dto.auth.AuthResponse;
import com.dashi.gymtracker.dto.auth.LoginRequest;
import com.dashi.gymtracker.dto.auth.RegisterRequest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface AuthService {
    AuthResponse login(LoginRequest request) throws UsernameNotFoundException;
    AuthResponse register(RegisterRequest request);
}