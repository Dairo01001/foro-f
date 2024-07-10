package dev.dairo.api_f.User.domain.repository;

import dev.dairo.api_f.Topic.domain.Topic;
import dev.dairo.api_f.User.domain.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User findById(UUID id);

    Optional<User> findByEmail(String email);

    User save(User user);

    List<User> findAll();

    List<Topic> findTopicsByUserId(UUID id);
}
