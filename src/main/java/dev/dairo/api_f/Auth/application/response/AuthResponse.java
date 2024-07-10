package dev.dairo.api_f.Auth.application.response;

import java.util.UUID;

public record AuthResponse (
        UUID id,
        String name,
        String email,
        String accessToken
) {
}
