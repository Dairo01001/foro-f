package dev.dairo.api_f.Auth.domain.service;

import dev.dairo.api_f.Auth.application.request.SignInRequest;
import dev.dairo.api_f.Auth.application.request.SignUpRequest;
import dev.dairo.api_f.Auth.application.response.AuthResponse;

public interface AuthService {
    AuthResponse signUp(SignUpRequest signUpRequest);

    AuthResponse signIn(SignInRequest signInRequest);
}
