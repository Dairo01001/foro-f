package dev.dairo.api_f.Auth.application.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record SignInRequest(
        @NotBlank @Email String email,
        @Min(6) String password
) {
}
