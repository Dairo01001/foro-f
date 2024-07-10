package dev.dairo.api_f.Topic.domain.service;

import dev.dairo.api_f.Course.domain.Course;
import dev.dairo.api_f.Course.domain.service.CourseService;
import dev.dairo.api_f.Topic.application.request.CreateTopicRequest;
import dev.dairo.api_f.Topic.application.request.UpdateTopicRequest;
import dev.dairo.api_f.Topic.application.response.CreateTopicResponse;
import dev.dairo.api_f.Topic.application.response.ListTopicResponse;
import dev.dairo.api_f.Topic.application.response.TopicResponse;
import dev.dairo.api_f.Topic.domain.Topic;
import dev.dairo.api_f.Topic.domain.repository.TopicRepository;
import dev.dairo.api_f.User.domain.User;
import dev.dairo.api_f.User.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DomainTopicService implements TopicService {

    private final TopicRepository topicRepository;
    private final CourseService courseService;
    private final UserService userService;

    @Override
    public CreateTopicResponse createTopic(CreateTopicRequest createTopicRequest) {
        if (topicRepository.existsByTitleAndMessage(createTopicRequest.title(), createTopicRequest.message())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Topic already exists");
        }

        Course course = courseService.getCourseById(createTopicRequest.courseId());
        User author = userService.findById(createTopicRequest.authorId());

        Topic newTopic = Topic.create(
                createTopicRequest.title(),
                createTopicRequest.message(),
                course,
                author
        );

        return CreateTopicResponse.fromTopic(topicRepository.saveTopic(newTopic));
    }

    @Override
    public TopicResponse getTopicById(UUID id) {
        Topic topic = topicRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic not found"));
        return TopicResponse.fromTopic(topic);
    }

    @Override
    public TopicResponse updateTopic(UUID id, UpdateTopicRequest updateTopicRequest) {
        Topic topic = topicRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic not found"));

        if(topicRepository.existsByTitleAndMessage(updateTopicRequest.title(), updateTopicRequest.message())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Topic already exists");
        }

        topic.update(updateTopicRequest.title(), updateTopicRequest.message(), updateTopicRequest.status());

        return TopicResponse.fromTopic(topicRepository.saveTopic(topic));
    }

    @Override
    public void deleteTopic(UUID id) {
        topicRepository.deleteById(id);
    }

    @Override
    public Topic getTopicId(UUID id) {
        return topicRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Topic not found"));
    }

    @Override
    public Page<ListTopicResponse> getTopics(Pageable pageable) {
        return topicRepository.findAll(pageable).map(ListTopicResponse::fromTopic);
    }
}
