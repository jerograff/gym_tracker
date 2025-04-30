package com.dashi.gymtracker.controller.auth;

import com.dashi.gymtracker.dto.auth.AuthResponse;
import com.dashi.gymtracker.dto.auth.LoginRequest;
import com.dashi.gymtracker.dto.auth.RegisterRequest;
import com.dashi.gymtracker.service.auth.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for authentication operations.
 */
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * Authenticate a user and issue a JWT token if credentials are valid.
     *
     * @param request Login request containing username and password.
     * @return JWT token if authentication is successful; 409 Conflict if user not found.
     */
    @Operation(summary = "Authenticate a user", description = "Validate credentials and return JWT token.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login successful"),
            @ApiResponse(responseCode = "409", description = "Invalid credentials")
    })
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
        AuthResponse response = null;
        try {
            response = authService.login(request);
            return ResponseEntity.ok(response);
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }
    /**
     * Register a new user in the system.
     *
     * @param request Register request containing user information.
     * @return JWT token if registration is successful; 409 Conflict if username or email already exist.
     */
    @Operation(summary = "Register a new user", description = "Create a new user and return JWT token.")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Registration successful"),
            @ApiResponse(responseCode = "409", description = "Username or Email already exists")
    })
    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request){
        AuthResponse response = null;
        try {
            System.out.println("REQUEST: " + request);
            response = authService.register(request);
            return ResponseEntity.ok(response);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }
    }
}
