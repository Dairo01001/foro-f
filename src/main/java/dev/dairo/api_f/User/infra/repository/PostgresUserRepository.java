package dev.dairo.api_f.User.infra.repository;

import dev.dairo.api_f.User.domain.User;
import dev.dairo.api_f.User.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostgresUserRepository implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.of(jpaUserRepository.findById(id).orElse(null));
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
}
