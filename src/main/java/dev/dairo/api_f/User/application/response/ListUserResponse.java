package dev.dairo.api_f.User.application.response;

import dev.dairo.api_f.User.domain.User;

import java.util.UUID;

public record ListUserResponse(
        UUID id,
        String name,
        String email
) {
    public static ListUserResponse fromUser(User user) {
        return new ListUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
