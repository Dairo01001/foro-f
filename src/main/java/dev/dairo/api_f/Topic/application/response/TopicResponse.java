package dev.dairo.api_f.Topic.application.response;

import dev.dairo.api_f.Topic.domain.Topic;

import java.time.LocalDate;
import java.util.List;

public record TopicResponse(
        String id,
        String title,
        String message,
        LocalDate createdAt,
        Boolean status,
        AuthorResponse author,
        CourseResponse course,
        List<ListAnswerResponse> answers
) {
    public static TopicResponse fromTopic(Topic topic) {
        return new TopicResponse(
                topic.getId().toString(),
                topic.getTitle(),
                topic.getMessage(),
                topic.getCreatedAt(),
                topic.getStatus(),
                AuthorResponse.fromAuthor(topic.getAuthor()),
                CourseResponse.fromCourse(topic.getCourse()),
                ListAnswerResponse.fromAnswers(topic.getAnswers())
        );
    }
}
