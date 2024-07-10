package dev.dairo.api_f.Answer.infra.repository;

import dev.dairo.api_f.Answer.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface JpaAnswerRepository extends JpaRepository<Answer, UUID> {

    @Query(value = """
            SELECT
                answers.id,
                answers.created_at,
                answers.solution,
                answers.message
            FROM
                answers
            ORDER BY
                created_at ASC
            """,
            nativeQuery = true
    )
    List<Answer> findAll();
}
