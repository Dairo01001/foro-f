package dev.dairo.api_f.Course.infra.repository;

import dev.dairo.api_f.Course.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCourseRepository extends JpaRepository<Course, UUID> {
    Boolean existsByName(String name);
}
