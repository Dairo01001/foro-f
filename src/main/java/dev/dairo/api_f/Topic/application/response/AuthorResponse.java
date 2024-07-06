package dev.dairo.api_f.Topic.application.response;

import dev.dairo.api_f.User.domain.User;

public record AuthorResponse(
        String id,
        String name,
        String email
) {
    public static AuthorResponse fromAuthor(User author) {
        return new AuthorResponse(
                author.getId().toString(),
                author.getName(),
                author.getEmail()
        );
    }
}
