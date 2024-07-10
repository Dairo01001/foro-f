package dev.dairo.api_f.User.infra.repository;

import dev.dairo.api_f.Topic.domain.Topic;
import dev.dairo.api_f.User.domain.User;
import dev.dairo.api_f.User.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostgresUserRepository implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public User findById(UUID id) {
        return jpaUserRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.of(jpaUserRepository.findByEmail(email));
    }

    @Override
    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll();
    }

    @Override
    public List<Topic> findTopicsByUserId(UUID id) {
        return jpaUserRepository.findTopicsByUserId(id);
    }
}
