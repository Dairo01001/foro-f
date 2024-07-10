package dev.dairo.api_f.Answer.domain.service;

import dev.dairo.api_f.Answer.domain.Answer;
import dev.dairo.api_f.Answer.domain.repository.AnswerRepository;
import dev.dairo.api_f.Topic.domain.Topic;
import dev.dairo.api_f.Topic.domain.service.TopicService;
import dev.dairo.api_f.User.domain.User;
import dev.dairo.api_f.User.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DomainAnswerService implements AnswerService {
    private final AnswerRepository answerRepository;
    private final TopicService topicService;
    private final UserService userService;

    @Override
    public Answer save(Answer answer, UUID topicId, UUID authorId) {

        Topic topic = topicService.getTopicId(topicId);
        User author = userService.findById(authorId);

        answer.setTopic(topic);
        answer.setAuthor(author);

        return answerRepository.saveAnswer(answer);
    }

    @Override
    public Answer getAnswerById(UUID id) {
        Optional<Answer> answer = answerRepository.getAnswerById(id);
        if (answer.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Answer not found");
        return answer.get();
    }

    @Override
    public List<Answer> findAll() {
        return answerRepository.findAll();
    }

    @Override
    public void delete(UUID id) {
        answerRepository.deleteById(id);
    }
}
