package dev.dairo.api_f.Auth.application.rest;

import dev.dairo.api_f.Auth.application.request.SignInRequest;
import dev.dairo.api_f.Auth.application.request.SignUpRequest;
import dev.dairo.api_f.Auth.application.response.AuthResponse;
import dev.dairo.api_f.Auth.domain.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
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
@Tag(name = "Auth", description = "Operations related to authentication")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/sign-up")
    @Transactional
    @Operation(summary = "Sign up a new user")
    public ResponseEntity<AuthResponse> signUp(
            @RequestBody @Valid SignUpRequest signUpRequest
    ) {
        return ResponseEntity.ok(authService.signUp(signUpRequest));
    }

    @PostMapping("/sign-in")
    @Operation(summary = "Sign in a user")
    public ResponseEntity<AuthResponse> signIn(@RequestBody @Valid SignInRequest signInRequest) {
        return ResponseEntity.ok(authService.signIn(signInRequest));
    }
}
