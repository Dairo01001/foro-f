package dev.dairo.api_f.Topic.application.rest;

import dev.dairo.api_f.Topic.application.request.CreateTopicRequest;
import dev.dairo.api_f.Topic.application.request.UpdateTopicRequest;
import dev.dairo.api_f.Topic.application.response.CreateTopicResponse;
import dev.dairo.api_f.Topic.application.response.ListTopicResponse;
import dev.dairo.api_f.Topic.application.response.TopicResponse;
import dev.dairo.api_f.Topic.domain.service.TopicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/topics")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-auth")
@Tag(name = "Topics", description = "Operations related to Topics")
public class TopicController {

    private final TopicService topicService;

    @PostMapping
    @Transactional
    @Operation(summary = "Create a new topic")
    public ResponseEntity<CreateTopicResponse> createTopic(
            @RequestBody @Valid CreateTopicRequest createTopicRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        CreateTopicResponse createTopicResponse = topicService.createTopic(createTopicRequest);
        URI location = uriComponentsBuilder
                .path("/topics/{id}")
                .buildAndExpand(createTopicResponse.id())
                .toUri();

        return ResponseEntity.created(location).body(createTopicResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a topic by id")
    public ResponseEntity<TopicResponse> getTopic(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok(topicService.getTopicById(id));
    }

    @PutMapping("/{id}")
    @Transactional
    @Operation(summary = "Update a topic by id")
    public ResponseEntity<TopicResponse> updateTopic(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateTopicRequest updateTopicRequest
    ) {
        return ResponseEntity.ok(topicService.updateTopic(id, updateTopicRequest));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a topic by id")
    public ResponseEntity<Void> deleteTopic(
            @PathVariable UUID id
    ) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @Operation(summary = "Get all topics")
    public ResponseEntity<List<ListTopicResponse>> getTopics() {
        return ResponseEntity.ok(topicService.getTopics());
    }
}
