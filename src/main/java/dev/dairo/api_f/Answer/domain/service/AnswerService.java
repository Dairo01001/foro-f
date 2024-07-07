package dev.dairo.api_f.Answer.domain.service;

import dev.dairo.api_f.Answer.application.request.CreateAnswerRequest;
import dev.dairo.api_f.Answer.application.response.AnswerResponse;
import dev.dairo.api_f.Answer.application.response.CreateAnswerResponse;

import java.util.UUID;

public interface AnswerService {
    CreateAnswerResponse createAnswer(CreateAnswerRequest createAnswerRequest);

    AnswerResponse getAnswerById(UUID id);
}
