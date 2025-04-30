package com.dashi.gymtracker.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    @NotBlank
    String username;
    @NotBlank
    String password;
    String firstname;
    String lastname;
    String country;
    @NotBlank
    @Email
    String email;
}