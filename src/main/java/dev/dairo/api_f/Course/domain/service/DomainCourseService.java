package dev.dairo.api_f.Course.domain.service;

import dev.dairo.api_f.Course.application.request.CreateCourseRequest;
import dev.dairo.api_f.Course.application.response.CreateCourseResponse;
import dev.dairo.api_f.Course.application.response.ListCourseResponse;
import dev.dairo.api_f.Course.domain.Course;
import dev.dairo.api_f.Course.domain.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DomainCourseService implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public CreateCourseResponse createCourse(CreateCourseRequest createCourseRequest) {
        if (courseRepository.existsByName(createCourseRequest.name())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Course already exists");
        }

        Optional<Course> newCourse = courseRepository.save(
                Course.register(createCourseRequest.name(),
                        createCourseRequest.category())
        );

        Course course = newCourse.get();

        return new CreateCourseResponse(
                course.getId().toString(),
                course.getName(),
                course.getCategory()
        );
    }

    @Override
    public void deleteCourse(UUID id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<ListCourseResponse> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses.stream().map(ListCourseResponse::fromCourse).toList();
    }

    @Override
    public Course getCourseById(UUID id) {
        return courseRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Course not found"));
    }
}
