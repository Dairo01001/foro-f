package dev.dairo.api_f.Answer.application.response;

import dev.dairo.api_f.User.domain.User;

import java.util.UUID;

public record AuthorAnswerResponse(
        UUID id,
        String name,
        String email
) {
    public static AuthorAnswerResponse fromAuthor(User author) {
        return new AuthorAnswerResponse(
                author.getId(),
                author.getName(),
                author.getEmail()
        );
    }
}
