package com.EduWise.EduWise.infra.presentation;

import com.EduWise.EduWise.core.domain.entities.StudentEnrollment;
import com.EduWise.EduWise.core.usecases.student_enrollment.*;
import com.EduWise.EduWise.infra.dtos.student_enrollment.EnrollmentRequest;
import com.EduWise.EduWise.infra.dtos.student_enrollment.EnrollmentResponse;
import com.EduWise.EduWise.infra.mappers.student_enrollment.StudentEnrollmentRequestResponseMapper;
import com.EduWise.EduWise.infra.presentation.api.StudentEnrollmentApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/student-enrollments/")
public class StudentEnrollmentController implements StudentEnrollmentApi {

    private final StudentEnrollmentRequestResponseMapper mapper;
    private final CreateStudentEnrollmentUseCase createStudentEnrollmentUseCase;
    private final GetAllStudentEnrollmentsUseCase getAllStudentEnrollmentsUseCase;
    private final GetStudentEnrollmentByIdUseCase getStudentEnrollmentByIdUseCase;
    private final UpdateStudentEnrollmentUseCase updateStudentEnrollmentUseCase;
    private final DeleteStudentEnrollmentUseCase deleteStudentEnrollmentUseCase;
    
    @Override
    @PostMapping()
    public ResponseEntity<EnrollmentResponse> createEnrollment(@Valid @RequestBody EnrollmentRequest request){
        StudentEnrollment savedEnrollment = createStudentEnrollmentUseCase.execute(mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toResponse(savedEnrollment));
    }

    @Override
    @GetMapping()
    public ResponseEntity<List<EnrollmentResponse>> getAllEnrollments(){
        List<EnrollmentResponse> enrollments = getAllStudentEnrollmentsUseCase.execute()
                .stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(enrollments);
    }

    @Override
    @GetMapping("{id}")
    public ResponseEntity<EnrollmentResponse> getEnrollmentById(@PathVariable Long id) {
        StudentEnrollment enrollment = getStudentEnrollmentByIdUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(enrollment));
    }

    @Override
    @PutMapping("{id}")
    public ResponseEntity<EnrollmentResponse> updateEnrollment(@PathVariable Long id, @Valid @RequestBody EnrollmentRequest request) {
        StudentEnrollment updatedEnrollment = updateStudentEnrollmentUseCase.execute(id, mapper.toDomain(request));
        return ResponseEntity.status(HttpStatus.OK).body(mapper.toResponse(updatedEnrollment));
    }

    @Override
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        deleteStudentEnrollmentUseCase.execute(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
