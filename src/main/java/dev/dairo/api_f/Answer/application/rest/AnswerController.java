package dev.dairo.api_f.Answer.application.rest;

import dev.dairo.api_f.Answer.application.request.CreateAnswerRequest;
import dev.dairo.api_f.Answer.application.response.AnswerResponse;
import dev.dairo.api_f.Answer.application.response.CreateAnswerResponse;
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
    public ResponseEntity<CreateAnswerResponse> createAnswer(
            @RequestBody @Valid CreateAnswerRequest createAnswerRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        CreateAnswerResponse createAnswerResponse = answerService.createAnswer(createAnswerRequest);
        URI location = uriComponentsBuilder
                .path("/answers/{id}")
                .buildAndExpand(createAnswerResponse.id())
                .toUri();

        return ResponseEntity.created(location).body(createAnswerResponse);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an answer by id")
    public ResponseEntity<AnswerResponse> getAnswer(
            @PathVariable UUID id
    ) {
        return ResponseEntity.ok(answerService.getAnswerById(id));
    }
}
