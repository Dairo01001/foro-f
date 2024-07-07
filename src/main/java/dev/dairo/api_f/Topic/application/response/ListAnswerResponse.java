package dev.dairo.api_f.Topic.application.response;

import dev.dairo.api_f.Answer.domain.Answer;

import java.util.List;

public record ListAnswerResponse(
        String id,
        String message,
        String solution,
        String createdAt
) {
    public static ListAnswerResponse fromAnswer(Answer answers) {
        return new ListAnswerResponse(
                answers.getId().toString(),
                answers.getMessage(),
                answers.getSolution(),
                answers.getCreatedAt().toString()
        );
    }

    public static List<ListAnswerResponse> fromAnswers(List<Answer> answers) {
        return answers.stream().map(ListAnswerResponse::fromAnswer).toList();
    }
}
