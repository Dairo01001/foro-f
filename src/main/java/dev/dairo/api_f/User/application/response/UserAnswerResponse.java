package dev.dairo.api_f.User.application.response;

import dev.dairo.api_f.Answer.domain.Answer;

import java.util.List;

public record UserAnswerResponse(
        String message,
        String solution,
        String createdAt
) {
    public static UserAnswerResponse fromAnswer(Answer answer) {
        return new UserAnswerResponse(
                answer.getMessage(),
                answer.getSolution(),
                answer.getCreatedAt().toString()
        );
    }

    public static List<UserAnswerResponse> fromAnswers(List<Answer> answers) {
        return answers.stream().map(UserAnswerResponse::fromAnswer).toList();
    }
}
