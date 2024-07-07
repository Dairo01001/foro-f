package dev.dairo.api_f.Topic.domain.repository;

import dev.dairo.api_f.Topic.domain.Topic;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TopicRepository {
    Boolean existsByTitleAndMessage(String title, String message);

    Topic saveTopic(Topic newTopic);

    Optional<Topic> findById(UUID id);

    void deleteById(UUID id);

    List<Topic> findAll();
}
