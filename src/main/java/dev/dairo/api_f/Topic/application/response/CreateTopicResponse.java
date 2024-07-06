package dev.dairo.api_f.Topic.application.response;

import dev.dairo.api_f.Topic.domain.Topic;

import java.time.LocalDate;
import java.util.UUID;

public record CreateTopicResponse(
        UUID id,
        String title,
        String message,
        LocalDate createdAt,
        Boolean status
) {
    public static CreateTopicResponse fromTopic(Topic topic) {
        return new CreateTopicResponse(
                topic.getId(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreatedAt(),
                topic.getStatus()
        );
    }
}
