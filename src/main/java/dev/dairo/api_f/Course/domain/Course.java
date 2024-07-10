package dev.dairo.api_f.Course.domain;

import dev.dairo.api_f.Topic.domain.Topic;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "Course")
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class Course {
    private @Id UUID id;
    private String name;
    private String category;

    @OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private List<Topic> topics;

    public Course(UUID id, String name, String category) {
        super();
        setId(id);
        setName(name);
        setCategory(category);
    }

    public static Course register(String name, String category) {
        return new Course(UUID.randomUUID(), name, category);
    }

    public void update(String name, String category) {
        if (name != null) setName(name);
        if (category != null) setCategory(category);
    }
}