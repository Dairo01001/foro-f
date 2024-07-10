package dev.dairo.api_f.User.application.response;

import dev.dairo.api_f.Topic.domain.Topic;

import java.util.List;
import java.util.UUID;

public record UserTopicResponse(
        UUID id,
        String title,
        String message
) {
    public static UserTopicResponse fromTopic(Topic topic) {
        return new UserTopicResponse(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage()
        );
    }

    public static List<UserTopicResponse> fromTopics(List<Topic> topics) {
        return topics.stream().map(UserTopicResponse::fromTopic).toList();
    }
}
