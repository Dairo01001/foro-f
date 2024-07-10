package dev.dairo.api_f.Answer.application.rest;

import dev.dairo.api_f.Answer.application.request.CreateAnswerRequest;
import dev.dairo.api_f.Answer.application.response.DetailsAnswerResponse;
import dev.dairo.api_f.Answer.application.response.ListAnswerResponse;
import dev.dairo.api_f.Answer.domain.Answer;
import dev.dairo.api_f.Answer.domain.service.AnswerService;
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
@RequestMapping("/answers")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-auth")
@Tag(name = "Answers", description = "Operations related to Answers")
public class AnswerController {

    private final AnswerService answerService;

    @PostMapping
    @Transactional
    @Operation(summary = "Create a new answer to a topic")
    public ResponseEntity<DetailsAnswerResponse> createAnswer(
            @RequestBody @Valid CreateAnswerRequest createAnswerRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        Answer answer = answerService.save(
                Answer.create(
                        createAnswerRequest.message(),
                        createAnswerRequest.solution()
                ),
                createAnswerRequest.topicId(),
                createAnswerRequest.authorId()
        );


        URI location = uriComponentsBuilder
                .path("/answers/{id}")
                .buildAndExpand(answer.getId())
                .toUri();

        return ResponseEntity.created(location).body(DetailsAnswerResponse.fromAnswer(answer));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an answer by id")
    public ResponseEntity<DetailsAnswerResponse> getAnswer(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok(DetailsAnswerResponse.fromAnswer(answerService.getAnswerById(id)));
    }

    @GetMapping
    @Operation(summary = "Get all answers")
    public ResponseEntity<List<ListAnswerResponse>> getAllAnswers() {

        return ResponseEntity.ok(
                answerService
                        .findAll()
                        .stream()
                        .map(ListAnswerResponse::fromAnswer)
                        .toList()
        );
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an answer by id")
    public ResponseEntity<Void> deleteAnswer(
            @PathVariable UUID id
    ) {
        answerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
