package dev.dairo.api_f.Answer.application.request;

import java.util.UUID;

public record CreateAnswerRequest(
        String message,
        String solution,
        UUID topicId,
        UUID authorId
) {
}
