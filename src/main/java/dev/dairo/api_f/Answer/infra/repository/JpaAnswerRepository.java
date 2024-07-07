package dev.dairo.api_f.Answer.infra.repository;

import dev.dairo.api_f.Answer.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaAnswerRepository extends JpaRepository<Answer, UUID> {
}
