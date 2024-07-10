package dev.dairo.api_f.User.domain;

import dev.dairo.api_f.Answer.domain.Answer;
import dev.dairo.api_f.Topic.domain.Topic;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class User implements UserDetails {
    private @Id UUID id;
    private String name;

    @Column(unique = true)
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Set<UserRole> roles;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Topic> topics;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    private List<Answer> answers;

    public User(UUID id, String name, String email, String password, Set<UserRole> roles) {
        super();
        setId(id);
        setName(name);
        setEmail(email);
        setPassword(password);
        setRoles(roles);
    }

    public static User create(String name, String email, String password, Set<UserRole> roles) {
       return new User(UUID.randomUUID(), name, email, password, roles);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .toList();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
