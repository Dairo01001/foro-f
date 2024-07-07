package dev.dairo.api_f.Topic.application.response;

import dev.dairo.api_f.Topic.domain.Topic;

import java.time.LocalDate;

public record ListTopicResponse(
        String id,
        String title,
        String message,
        LocalDate createdAt
) {
    public static ListTopicResponse fromTopic(Topic topic) {
        return new ListTopicResponse(
                topic.getId().toString(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreatedAt()
        );
    }
}
