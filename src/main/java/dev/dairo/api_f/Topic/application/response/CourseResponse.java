package dev.dairo.api_f.Topic.application.response;

import dev.dairo.api_f.Course.domain.Course;

public record CourseResponse(
        String id,
        String name,
        String category
) {
    public static CourseResponse fromCourse(Course course) {
        return new CourseResponse(
                course.getId().toString(),
                course.getName(),
                course.getCategory()
        );
    }
}
