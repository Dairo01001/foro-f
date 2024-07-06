package dev.dairo.api_f.Course.infra.repository;

import dev.dairo.api_f.Course.domain.Course;
import dev.dairo.api_f.Course.domain.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PostgresCourseRepository implements CourseRepository {

    private final JpaCourseRepository jpaCourseRepository;

    @Override
    public Optional<Course> findById(UUID id) {
        return Optional.of(jpaCourseRepository.findById(id).orElse(null));
    }

    @Override
    public Boolean existsByName(String name) {
        return jpaCourseRepository.existsByName(name);
    }

    @Override
    public Optional<Course> save(Course course) {
        return Optional.of(jpaCourseRepository.save(course));
    }

    @Override
    public void deleteById(UUID id) {
        jpaCourseRepository.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return jpaCourseRepository.findAll();
    }
}
