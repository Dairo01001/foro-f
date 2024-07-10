package dev.dairo.api_f.Answer.infra.repository;

import dev.dairo.api_f.Answer.domain.Answer;
import dev.dairo.api_f.Answer.domain.repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostgresAnswerRepository implements AnswerRepository {
    private final JpaAnswerRepository jpaAnswerRepository;

    @Override
    public Answer saveAnswer(Answer answer) {
        return jpaAnswerRepository.save(answer);
    }

    @Override
    public Optional<Answer> getAnswerById(UUID id) {
        return jpaAnswerRepository.findById(id);
    }

    @Override
    public List<Answer> findAll() {
        return jpaAnswerRepository.findAll();
    }

    @Override
    public void deleteById(UUID id) {
        jpaAnswerRepository.deleteById(id);
    }
}
