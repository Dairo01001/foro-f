package dev.dairo.api_f.Auth.application.rest;

import dev.dairo.api_f.Auth.application.request.SignInRequest;
import dev.dairo.api_f.Auth.application.request.SignUpRequest;
import dev.dairo.api_f.Auth.application.response.AuthResponse;
import dev.dairo.api_f.Auth.domain.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> signUp(
            @RequestBody @Valid SignUpRequest signUpRequest
    ) {
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponse> signIn(@RequestBody @Valid SignInRequest signInRequest) {
        return ResponseEntity.ok(authService.signIn(signInRequest));
    }
}
