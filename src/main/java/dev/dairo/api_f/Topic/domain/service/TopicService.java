package dev.dairo.api_f.Topic.domain.service;

import dev.dairo.api_f.Topic.application.request.CreateTopicRequest;
import dev.dairo.api_f.Topic.application.request.UpdateTopicRequest;
import dev.dairo.api_f.Topic.application.response.CreateTopicResponse;
import dev.dairo.api_f.Topic.application.response.ListTopicResponse;
import dev.dairo.api_f.Topic.application.response.TopicResponse;
import dev.dairo.api_f.Topic.domain.Topic;

import java.util.List;
import java.util.UUID;

public interface TopicService {
    CreateTopicResponse createTopic(CreateTopicRequest createTopicRequest);

    TopicResponse getTopicById(UUID id);

    TopicResponse updateTopic(UUID id, UpdateTopicRequest updateTopicRequest);

    void deleteTopic(UUID id);

    Topic getTopicId(UUID id);

    List<ListTopicResponse> getTopics();
}
