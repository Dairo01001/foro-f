package dev.dairo.api_f.Answer.domain;

import dev.dairo.api_f.Topic.domain.Topic;
import dev.dairo.api_f.User.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "Answer")
@Table(name = "answers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Answer {
    private @Id UUID id;
    private String message;
    private LocalDate createdAt;
    private String solution;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private User author;

    public Answer(UUID id, String message, LocalDate createdAt, String solution) {
        super();
        setId(id);
        setMessage(message);
        setCreatedAt(createdAt);
        setSolution(solution);
    }

    public static Answer create(String message, String solution) {
        return new Answer(UUID.randomUUID(), message, LocalDate.now(), solution);
    }
}