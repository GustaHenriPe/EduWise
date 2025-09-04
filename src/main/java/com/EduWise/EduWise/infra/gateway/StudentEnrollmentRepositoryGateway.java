package com.EduWise.EduWise.infra.gateway;

import com.EduWise.EduWise.core.domain.StudentEnrollment;
import com.EduWise.EduWise.core.gateway.StudentEnrollmentGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentEnrollmentRepositoryGateway implements StudentEnrollmentGateway {
    @Override
    public StudentEnrollment createStudentEnrollment(StudentEnrollment enrollment) {
        return null;
    }

    @Override
    public List<StudentEnrollment> getAllStudentEnrollments() {
        return List.of();
    }

    @Override
    public StudentEnrollment getStudentEnrollmentById(Long id) {
        return null;
    }

    @Override
    public StudentEnrollment updateStudentEnrollment(Long id, StudentEnrollment enrollment) {
        return null;
    }

    @Override
    public void deleteStudentEnrollment(Long id) {
    }
}

