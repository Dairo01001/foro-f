package dev.dairo.api_f.Topic.domain.repository;

import dev.dairo.api_f.Topic.domain.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TopicRepository {
    Boolean existsByTitleAndMessage(String title, String message);

    Topic saveTopic(Topic newTopic);

    Optional<Topic> findById(UUID id);

    void deleteById(UUID id);

    Page<Topic> findAll(Pageable pageable);
}
