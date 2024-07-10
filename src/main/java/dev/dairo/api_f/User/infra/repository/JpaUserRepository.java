package dev.dairo.api_f.User.infra.repository;

import dev.dairo.api_f.Topic.domain.Topic;
import dev.dairo.api_f.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface JpaUserRepository extends JpaRepository<User, UUID> {
    User findByEmail(String email);

    @Query(value = """
            SELECT
                users.id,
                users.name,
                users.email,
                users.password,
                users.roles
            FROM
                users
            ORDER BY
                users.name ASC
            """,
            nativeQuery = true
    )
    List<User> findAll();

    @Query(value = """
            SELECT
                topics.id,
                topics.title,
                topics.message,
                topics.created_at,
                topics.author_id
            FROM
                topics
            WHERE
                topics.author_id = ?
            ORDER BY
                topics.created_at ASC
            """,
            nativeQuery = true
    )
    List<Topic> findTopicsByUserId(UUID id);
}
