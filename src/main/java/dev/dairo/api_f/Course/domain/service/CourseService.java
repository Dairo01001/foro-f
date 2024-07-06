package dev.dairo.api_f.Course.domain.service;

import dev.dairo.api_f.Course.application.request.CreateCourseRequest;
import dev.dairo.api_f.Course.application.response.CreateCourseResponse;
import dev.dairo.api_f.Course.application.response.ListCourseResponse;
import dev.dairo.api_f.Course.domain.Course;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    CreateCourseResponse createCourse(CreateCourseRequest createCourseRequest);
    void deleteCourse(UUID id);
    List<ListCourseResponse> getAllCourses();

    Course getCourseById(UUID id);
}
