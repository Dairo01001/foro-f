package dev.dairo.api_f.User.domain.service;

import dev.dairo.api_f.User.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {

    UserDetailsService getUserDetailsService();

    User saveUser(User user);

    User findByEmail(String email);
}
