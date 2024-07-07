package dev.dairo.api_f.Answer.application.response;

import dev.dairo.api_f.Answer.domain.Answer;

import java.time.LocalDate;
import java.util.UUID;

public record CreateAnswerResponse(
        UUID id,
        String message,
        String solution,
        LocalDate createdAt
) {
    public static CreateAnswerResponse fromAnswer(Answer answer) {
        return new CreateAnswerResponse(
                answer.getId(),
                answer.getMessage(),
                answer.getSolution(),
                answer.getCreatedAt()
        );
    }
}
