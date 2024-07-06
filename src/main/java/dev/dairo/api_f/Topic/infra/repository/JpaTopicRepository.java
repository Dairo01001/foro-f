package dev.dairo.api_f.Topic.infra.repository;

import dev.dairo.api_f.Topic.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTopicRepository extends JpaRepository<Topic, UUID> {
    Boolean existsByTitleAndMessage(String title, String message);
}
