package dev.dairo.api_f.User.infra.repository;

import dev.dairo.api_f.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);
}
