package dev.dairo.api_f.Course.domain.repository;

import dev.dairo.api_f.Course.domain.Course;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository {
    Optional<Course> findById(UUID id);
    Boolean existsByName(String name);
    Optional<Course> save(Course course);
    void deleteById(UUID id);
    List<Course> findAll();
}
