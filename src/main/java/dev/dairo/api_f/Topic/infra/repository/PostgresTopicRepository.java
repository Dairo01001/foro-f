package dev.dairo.api_f.Topic.infra.repository;

import dev.dairo.api_f.Answer.domain.Answer;
import dev.dairo.api_f.Topic.domain.Topic;
import dev.dairo.api_f.Topic.domain.repository.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostgresTopicRepository implements TopicRepository {

    private final JpaTopicRepository jpaTopicRepository;

    @Override
    public Boolean existsByTitleAndMessage(String title, String message) {
        return jpaTopicRepository.existsByTitleAndMessage(title, message);
    }

    @Override
    public Topic saveTopic(Topic newTopic) {
        return jpaTopicRepository.save(newTopic);
    }

    @Override
    public Optional<Topic> findById(UUID id) {
        return Optional.of(jpaTopicRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteById(UUID id) {
        jpaTopicRepository.deleteById(id);
    }

    @Override
    public List<Topic> findAll() {
        return jpaTopicRepository.findAll();
    }
}
