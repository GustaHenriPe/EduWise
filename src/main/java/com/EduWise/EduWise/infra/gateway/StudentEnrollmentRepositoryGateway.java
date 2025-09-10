package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.StudentEnrollment;
import com.EduWise.EduWise.core.gateway.StudentEnrollmentGateway;
import com.EduWise.EduWise.infra.mappers.student_enrollment.StudentEnrollmentEntityMapper;
import com.EduWise.EduWise.infra.persistence.entities.StudentEnrollmentEntity;
import com.EduWise.EduWise.infra.persistence.repositories.StudentEnrollmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class StudentEnrollmentRepositoryGateway implements StudentEnrollmentGateway {
    private final StudentEnrollmentEntityMapper mapper;
    private final StudentEnrollmentRepository repository;
    private final UserRepositoryGateway userGateway;
    private final CourseRepositoryGateway courseGateway;

    @Override
    public StudentEnrollment createStudentEnrollment(StudentEnrollment enrollment) {
        StudentEnrollmentEntity enrollmentEntity = mapper.toEntity(enrollment);
        enrollmentEntity.setCourseEntity(courseGateway.verifyExistingCourse(enrollment.courseId()));
        enrollmentEntity.setUserEntity(userGateway.verifyUserById(enrollment.userId()));
        return mapper.toDomain(repository.save(enrollmentEntity));
    }

    @Override
    public List<StudentEnrollment> getAllStudentEnrollments() {
        return repository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public StudentEnrollment getStudentEnrollmentById(Long id) {
        StudentEnrollmentEntity existingEnrollment = verifyStudentEnrollmentById(id);
        return mapper.toDomain(existingEnrollment);
    }

    @Override
    public StudentEnrollment updateStudentEnrollment(Long id, StudentEnrollment enrollment) {
        StudentEnrollmentEntity existingEnrollment = verifyStudentEnrollmentById(id);

        existingEnrollment.setUserEntity(userGateway.verifyUserById(enrollment.userId()));
        existingEnrollment.setCourseEntity(courseGateway.verifyExistingCourse(enrollment.courseId()));

        StudentEnrollmentEntity updatedEnrollment = repository.save(existingEnrollment);
        return mapper.toDomain(updatedEnrollment);
    }

    @Override
    public void deleteStudentEnrollment(Long id) {
        StudentEnrollmentEntity existingEnrollment = verifyStudentEnrollmentById(id);
        repository.delete(existingEnrollment);
    }

    public StudentEnrollmentEntity verifyStudentEnrollmentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Enrollment not found with ID: " + id));
    }
}

