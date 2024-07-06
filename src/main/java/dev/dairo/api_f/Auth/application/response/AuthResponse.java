package dev.dairo.api_f.Auth.application.response;

public record AuthResponse (
        String name,
        String email,
        String accessToken
) {
}
