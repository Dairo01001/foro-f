package dev.dairo.api_f.Answer.application.response;

import dev.dairo.api_f.Answer.domain.Answer;
import dev.dairo.api_f.Topic.application.response.AuthorResponse;

import java.time.LocalDate;

public record AnswerResponse(
        String id,
        String message,
        String solution,
        LocalDate createdAt,
        AuthorResponse author,
        TopicResponse topic
) {
    public static AnswerResponse fromAnswer(Answer answer) {
        return new AnswerResponse(
                answer.getId().toString(),
                answer.getMessage(),
                answer.getSolution(),
                answer.getCreatedAt(),
                AuthorResponse.fromAuthor(answer.getAuthor()),
                TopicResponse.fromTopic(answer.getTopic())
        );
    }
}
