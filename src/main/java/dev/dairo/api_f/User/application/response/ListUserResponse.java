package dev.dairo.api_f.User.application.response;

import dev.dairo.api_f.User.domain.User;

public record ListUserResponse(
        String id,
        String name,
        String email
) {
    public static ListUserResponse fromUser(User user) {
        return new ListUserResponse(
                user.getId().toString(),
                user.getName(),
                user.getEmail()
        );
    }
}
