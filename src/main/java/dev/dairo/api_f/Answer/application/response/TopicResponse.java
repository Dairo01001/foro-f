package dev.dairo.api_f.Answer.application.response;

import dev.dairo.api_f.Topic.domain.Topic;

public record TopicResponse(
        String id,
        String title,
        String message
) {
    public static TopicResponse fromTopic(Topic topic) {
        return new TopicResponse(
                topic.getId().toString(),
                topic.getTitle(),
                topic.getMessage()
        );
    }
}
