package dev.dairo.api_f.Answer.domain.service;

import dev.dairo.api_f.Answer.application.request.CreateAnswerRequest;
import dev.dairo.api_f.Answer.application.response.AnswerResponse;
import dev.dairo.api_f.Answer.application.response.CreateAnswerResponse;
import dev.dairo.api_f.Answer.domain.Answer;
import dev.dairo.api_f.Answer.domain.repository.AnswerRepository;
import dev.dairo.api_f.Topic.domain.Topic;
import dev.dairo.api_f.Topic.domain.service.TopicService;
import dev.dairo.api_f.User.domain.User;
import dev.dairo.api_f.User.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DomainAnswerService implements AnswerService {
    private final AnswerRepository answerRepository;
    private final TopicService topicService;
    private final UserService userService;

    @Override
    public CreateAnswerResponse createAnswer(CreateAnswerRequest createAnswerRequest) {

        Topic topic = topicService.getTopicId(createAnswerRequest.topicId());
        User author = userService.getUserById(createAnswerRequest.authorId());

        Answer answer = Answer.create(
                createAnswerRequest.message(),
                createAnswerRequest.solution(),
                topic,
                author
        );

        return CreateAnswerResponse.fromAnswer(answerRepository.saveAnswer(answer));
    }

    @Override
    public AnswerResponse getAnswerById(UUID id) {
        Optional<Answer> answer = answerRepository.getAnswerById(id);

        return AnswerResponse.fromAnswer(answer.get());
    }
}
