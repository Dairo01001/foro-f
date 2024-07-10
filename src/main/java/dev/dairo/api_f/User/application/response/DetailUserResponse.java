package dev.dairo.api_f.User.application.response;

import dev.dairo.api_f.Answer.domain.Answer;
import dev.dairo.api_f.User.domain.User;

import java.util.List;
import java.util.UUID;

public record DetailUserResponse(
        UUID id,
        String name,
        String email,
        List<String> roles,
        List<UserTopicResponse> topics,
        List<UserAnswerResponse> answers
) {
    public static DetailUserResponse fromUser(User user) {
        return new DetailUserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRoles().stream().map(role -> role.name()).toList(),
                user.getTopics().stream().map(UserTopicResponse::fromTopic).toList(),
                user.getAnswers().stream().map(UserAnswerResponse::fromAnswer).toList()
        );
    }
}
