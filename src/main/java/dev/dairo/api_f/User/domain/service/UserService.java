package dev.dairo.api_f.User.domain.service;

import dev.dairo.api_f.User.application.response.ListUserResponse;
import dev.dairo.api_f.User.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDetailsService getUserDetailsService();

    User saveUser(User user);

    User findByEmail(String email);

    User getUserById(UUID id);

    List<ListUserResponse> getAllUsers();
}
