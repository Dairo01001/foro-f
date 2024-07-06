package dev.dairo.api_f.Auth.application.request;

import dev.dairo.api_f.User.domain.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record SignUpRequest(
        @NotBlank String name,
        @NotBlank @Email String email,
        @Min(6) String password,
        @NotNull Set<UserRole> roles
) {
}