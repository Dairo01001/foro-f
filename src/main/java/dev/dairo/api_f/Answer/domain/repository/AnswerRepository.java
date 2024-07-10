package dev.dairo.api_f.Answer.domain.repository;

import dev.dairo.api_f.Answer.domain.Answer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AnswerRepository {
    Answer saveAnswer(Answer answer);

    Optional<Answer> getAnswerById(UUID id);

    List<Answer> findAll();

    void deleteById(UUID id);
}
