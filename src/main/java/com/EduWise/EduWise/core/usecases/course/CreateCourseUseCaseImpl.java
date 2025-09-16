package com.EduWise.EduWise.core.usecases.course;

import com.EduWise.EduWise.core.domain.entities.Course;
import com.EduWise.EduWise.core.domain.exceptions.UserRoleNotAllowedException;
import com.EduWise.EduWise.core.enums.Roles;
import com.EduWise.EduWise.core.gateway.CourseGateway;
import com.EduWise.EduWise.core.usecases.user.VerifyUserRoleUseCase;

public class CreateCourseUseCaseImpl implements CreateCourseUseCase {

    private final CourseGateway gateway;
    private final VerifyUserRoleUseCase verifyUserRoleUseCase;

    public CreateCourseUseCaseImpl(CourseGateway gateway, VerifyUserRoleUseCase verifyUserRoleUseCase) {
        this.gateway = gateway;
        this.verifyUserRoleUseCase = verifyUserRoleUseCase;
    }

    @Override
    public Course execute(Course course) {
        if (verifyUserRoleUseCase.execute(course.teacherId()) == Roles.STUDENT){
            throw new UserRoleNotAllowedException("Only teachers can create courses.");
        }

        return gateway.createCourse(course);
    }
}
