package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.Course;
import com.EduWise.EduWise.core.gateway.CourseGateway;
import com.EduWise.EduWise.infra.mappers.course.CourseEntityMapper;
import com.EduWise.EduWise.infra.persistence.entities.CourseCategoryEntity;
import com.EduWise.EduWise.infra.persistence.entities.CourseEntity;
import com.EduWise.EduWise.infra.persistence.entities.UserEntity;
import com.EduWise.EduWise.infra.persistence.repositories.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CourseRepositoryGateway implements CourseGateway {

    private final CourseRepository courseRepository;
    private final CourseEntityMapper mapper;
    private final UserRepositoryGateway userGateway;
    private final CourseCategoryRepositoryGateway categoryGateway;

    @Override
    public Course createCourse(Course course) {
        Long teacherId = course.teacherId();
        UserEntity teacher = userGateway.verifyUserById(course.teacherId());
        CourseCategoryEntity category = categoryGateway.verifyExistingCourseCategory(course.categoryId());
        CourseEntity courseEntity = mapper.toEntity(course);
        courseEntity.setTeacher(teacher);
        courseEntity.setCategory(category);
        CourseEntity savedCourse = courseRepository.save(courseEntity);
        return mapper.toDomain(savedCourse);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Course getCourseById(Long id) {
        CourseEntity course = verifyExistingCourse(id);
        return mapper.toDomain(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        CourseEntity existingCourse = verifyExistingCourse(id);

        UserEntity teacher = userGateway
                .verifyUserById(course.teacherId());

        CourseCategoryEntity category = categoryGateway
                .verifyExistingCourseCategory(course.categoryId());

        existingCourse.setTitle(course.title());
        existingCourse.setDescription(course.description());
        existingCourse.setTeacher(teacher);
        existingCourse.setCategory(category);

        CourseEntity updatedCourse = courseRepository.save(existingCourse);
        return mapper.toDomain(updatedCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        CourseEntity existingCourse = verifyExistingCourse(id);
        courseRepository.deleteById(id);
    }

    public CourseEntity verifyExistingCourse(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + id));
    }
}

