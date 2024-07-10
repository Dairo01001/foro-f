package dev.dairo.api_f.Answer.domain.service;

import dev.dairo.api_f.Answer.domain.Answer;

import java.util.List;
import java.util.UUID;

public interface AnswerService {
    Answer save(Answer answer, UUID topicId, UUID authorId);

    Answer getAnswerById(UUID id);

    List<Answer> findAll();

    void delete(UUID id);
}
