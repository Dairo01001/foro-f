package dev.dairo.api_f.Answer.application.response;

import dev.dairo.api_f.Answer.domain.Answer;

import java.util.UUID;

public record ListAnswerResponse(
        UUID id,
        String message,
        String solution,
        String createdAt
) {
    public static ListAnswerResponse fromAnswer(Answer answer) {
        return new ListAnswerResponse(
                answer.getId(),
                answer.getMessage(),
                answer.getSolution(),
                answer.getCreatedAt().toString()
        );
    }
}
