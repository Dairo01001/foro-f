package dev.dairo.api_f.Topic.domain;

import dev.dairo.api_f.Answer.domain.Answer;
import dev.dairo.api_f.Course.domain.Course;
import dev.dairo.api_f.User.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "Topic")
@Table(name = "topics")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Topic {
    private @Id UUID id;
    private String title;
    private String message;
    private LocalDate createdAt;
    private Boolean status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
    private List<Answer> answers;

    public static Topic create(String title, String message, Course course, User author) {
        return new Topic(UUID.randomUUID(), title, message, LocalDate.now(), true, course, author, List.of());
    }

    public void update(String title, String message, Boolean status) {
        if (title != null) setTitle(title);
        if (message != null) setMessage(message);
        if (status != null) setStatus(status);
    }
}
