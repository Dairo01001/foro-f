package dev.dairo.api_f.User.application.rest;

import dev.dairo.api_f.User.application.response.DetailUserResponse;
import dev.dairo.api_f.User.application.response.ListUserResponse;
import dev.dairo.api_f.User.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-auth")
@Tag(name = "Users", description = "Operations related to Users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @Operation(summary = "Get all users")
    public ResponseEntity<List<ListUserResponse>> getUsers() {
        return ResponseEntity.ok(
                userService
                        .findAll()
                        .stream()
                        .map(ListUserResponse::fromUser)
                        .toList()
        );
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get user by id")
    public ResponseEntity<DetailUserResponse> getUserById(@PathVariable UUID id) {
        return ResponseEntity.ok(DetailUserResponse.fromUser(userService.findById(id)));
    }
}
