package dev.dairo.api_f.Course.application.rest;

import dev.dairo.api_f.Course.application.request.CreateCourseRequest;
import dev.dairo.api_f.Course.application.response.CreateCourseResponse;
import dev.dairo.api_f.Course.application.response.ListCourseResponse;
import dev.dairo.api_f.Course.domain.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/courses")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearer-auth")
@Tag(name = "Courses", description = "Operations related to Courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping
    @Transactional
    @Operation(summary = "Create a new course")
    public ResponseEntity<CreateCourseResponse> createCourse(
            @RequestBody @Valid CreateCourseRequest createCourseRequest,
            UriComponentsBuilder uriComponentsBuilder
    ) {
        CreateCourseResponse createCourseResponse = courseService.createCourse(createCourseRequest);

        URI location = uriComponentsBuilder
                .path("/courses/{id}")
                .buildAndExpand(createCourseResponse.id())
                .toUri();

        return ResponseEntity.created(location).body(createCourseResponse);
    }

    @GetMapping
    @Operation(summary = "Get all courses")
    public ResponseEntity<List<ListCourseResponse>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Operation(summary = "Delete a course")
    public ResponseEntity<Void> deleteCourse(@PathVariable UUID id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
