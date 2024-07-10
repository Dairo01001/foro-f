package dev.dairo.api_f.Answer.application.response;

import dev.dairo.api_f.Topic.domain.Topic;

import java.util.UUID;

public record TopicAnswerResponse(
        UUID id,
        String title,
        String message
) {
    public static TopicAnswerResponse fromTopic(Topic topic) {
        return new TopicAnswerResponse(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage()
        );
    }
}
