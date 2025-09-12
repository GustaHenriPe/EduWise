package com.EduWise.EduWise.infra.presentation;

import com.EduWise.EduWise.core.domain.StudentEnrollment;
import com.EduWise.EduWise.core.usecases.student_enrollment.*;
import com.EduWise.EduWise.infra.dtos.student_enrollment.EnrollmentRequest;
import com.EduWise.EduWise.infra.dtos.student_enrollment.EnrollmentResponse;
import com.EduWise.EduWise.infra.mappers.student_enrollment.StudentEnrollmentRequestResponseMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student-enrollments/")
public class StudentEnrollmentController {
    
    private final StudentEnrollmentRequestResponseMapper mapper;
    private final CreateStudentEnrollmentUseCase createStudentEnrollmentUseCase;
    private final GetAllStudentEnrollmentsUseCase getAllStudentEnrollmentsUseCase;
    private final GetStudentEnrollmentByIdUseCase getStudentEnrollmentByIdUseCase;
    private final UpdateStudentEnrollmentUseCase updateStudentEnrollmentUseCase;
    private final DeleteStudentEnrollmentUseCase deleteStudentEnrollmentUseCase;
    
    @PostMapping()
    public EnrollmentResponse createEnrollment(@Valid @RequestBody EnrollmentRequest request){
        StudentEnrollment savedEnrollment = createStudentEnrollmentUseCase.execute(mapper.toDomain(request));
        return mapper.toResponse(savedEnrollment);
    }

    @GetMapping()
    public List<EnrollmentResponse> getAllEnrollments(){
        return getAllStudentEnrollmentsUseCase.execute()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
    @GetMapping("{id}")
    public EnrollmentResponse getEnrollmentById(@PathVariable Long id) {
        StudentEnrollment enrollment = getStudentEnrollmentByIdUseCase.execute(id);
        return mapper.toResponse(enrollment);
    }

    @PutMapping("{id}")
    public EnrollmentResponse updateEnrollment(@PathVariable Long id,@Valid @RequestBody EnrollmentRequest request) {
        StudentEnrollment updatedEnrollment = updateStudentEnrollmentUseCase.execute(id, mapper.toDomain(request));
        return mapper.toResponse(updatedEnrollment);
    }

    @DeleteMapping("{id}")
    public void deleteEnrollment(@PathVariable Long id) {
        deleteStudentEnrollmentUseCase.execute(id);
    }
}
