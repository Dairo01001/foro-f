package dev.dairo.api_f.Topic.application.request;

public record UpdateTopicRequest(
        String title,
        String message,
        Boolean status
) {
}
