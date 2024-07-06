package dev.dairo.api_f.Topic.application.request;

import java.util.UUID;

public record CreateTopicRequest(
        String title,
        String message,
        UUID courseId,
        UUID authorId
) {
}
