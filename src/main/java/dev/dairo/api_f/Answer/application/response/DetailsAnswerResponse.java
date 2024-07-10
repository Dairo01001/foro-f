package dev.dairo.api_f.Answer.application.response;

import dev.dairo.api_f.Answer.domain.Answer;

import java.util.UUID;

public record DetailsAnswerResponse(
        UUID id,
        String message,
        String solution,
        String createdAt,
        TopicAnswerResponse topic,
        AuthorAnswerResponse author
) {
    public static DetailsAnswerResponse fromAnswer(Answer answer) {
        return new DetailsAnswerResponse(
                answer.getId(),
                answer.getMessage(),
                answer.getSolution(),
                answer.getCreatedAt().toString(),
                TopicAnswerResponse.fromTopic(answer.getTopic()),
                AuthorAnswerResponse.fromAuthor(answer.getAuthor())
        );
    }
}
