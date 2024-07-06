package dev.dairo.api_f.Course.application.response;

import dev.dairo.api_f.Course.domain.Course;

public record ListCourseResponse(
        String id,
        String name,
        String category
) {
    public static ListCourseResponse fromCourse(Course course) {
        return new ListCourseResponse(
                course.getId().toString(),
                course.getName(),
                course.getCategory()
        );
    }
}
