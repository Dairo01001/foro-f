package dev.dairo.api_f.User.domain.service;

import dev.dairo.api_f.Topic.domain.Topic;
import dev.dairo.api_f.User.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserDetailsService getUserDetailsService();

    User save(User user);

    User findByEmail(String email);

    User findById(UUID id);

    List<User> findAll();

    List<Topic> findTopicsByUserId(UUID id);
}
