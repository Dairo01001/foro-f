package dev.dairo.api_f.Auth.domain.service;

import dev.dairo.api_f.Auth.application.request.SignInRequest;
import dev.dairo.api_f.Auth.application.request.SignUpRequest;
import dev.dairo.api_f.Auth.application.response.AuthResponse;
import dev.dairo.api_f.User.domain.User;
import dev.dairo.api_f.User.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomainAuthService implements AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse signUp(SignUpRequest signUpRequest) {
        User newUser = userService.save(
                User.create(
                        signUpRequest.name(),
                        signUpRequest.email(),
                        passwordEncoder.encode(signUpRequest.password()),
                        signUpRequest.roles()
                )
        );

        return new AuthResponse(
                newUser.getId(),
                newUser.getName(),
                newUser.getEmail(),
                jwtService.generateToken(newUser)
        );
    }

    @Override
    public AuthResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        signInRequest.email(),
                        signInRequest.password()
                )
        );
        User user = userService.findByEmail(signInRequest.email());
        return new AuthResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                jwtService.generateToken(user)
        );
    }
}
