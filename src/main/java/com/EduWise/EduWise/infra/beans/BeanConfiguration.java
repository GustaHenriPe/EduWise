package com.EduWise.EduWise.infra.beans;

import com.EduWise.EduWise.core.gateway.*;
import com.EduWise.EduWise.core.usecases.course.*;
import com.EduWise.EduWise.core.usecases.user.*;
import com.EduWise.EduWise.core.usecases.module.*;
import com.EduWise.EduWise.core.usecases.lesson.*;
import com.EduWise.EduWise.core.usecases.coursecategorie.*;
import com.EduWise.EduWise.core.usecases.studentenrollment.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    // Course Use Cases
    @Bean
    public CreateCourseUseCase createCourse(CourseGateway gateway) {
        return new CreateCourseUseCaseImpl(gateway);
    }

    @Bean
    public GetAllCoursesUseCase getAllCourses(CourseGateway gateway) {
        return new GetAllCoursesUseCaseImpl(gateway);
    }

    @Bean
    public GetCourseByIdUseCase getCourseById(CourseGateway gateway) {
        return new GetCourseByIdUseCaseImpl(gateway);
    }

    @Bean
    public UpdateCourseUseCase updateCourse(CourseGateway gateway) {
        return new UpdateCourseUseCaseImpl(gateway);
    }

    @Bean
    public DeleteCourseUseCase deleteCourse(CourseGateway gateway) {
        return new DeleteCourseUseCaseImpl(gateway);
    }

    // User Use Cases
    @Bean
    public CreateUserUseCase createUser(UserGateway gateway) {
        return new CreateUserUseCaseImpl(gateway);
    }

    @Bean
    public GetAllUsersUseCase getAllUsers(UserGateway gateway) {
        return new GetAllUsersUseCaseImpl(gateway);
    }

    @Bean
    public GetUserByIdUseCase getUserById(UserGateway gateway) {
        return new GetUserByIdUseCaseImpl(gateway);
    }

    @Bean
    public UpdateUserUseCase updateUser(UserGateway gateway) {
        return new UpdateUserUseCaseImpl(gateway);
    }

    @Bean
    public DeleteUserUseCase deleteUser(UserGateway gateway) {
        return new DeleteUserUseCaseImpl(gateway);
    }

    // Module Use Cases
    @Bean
    public CreateModuleUseCase createModule(ModuleGateway gateway) {
        return new CreateModuleUseCaseImpl(gateway);
    }

    @Bean
    public GetAllModulesUseCase getAllModules(ModuleGateway gateway) {
        return new GetAllModulesUseCaseImpl(gateway);
    }

    @Bean
    public GetModuleByIdUseCase getModuleById(ModuleGateway gateway) {
        return new GetModuleByIdUseCaseImpl(gateway);
    }

    @Bean
    public UpdateModuleUseCase updateModule(ModuleGateway gateway) {
        return new UpdateModuleUseCaseImpl(gateway);
    }

    @Bean
    public DeleteModuleUseCase deleteModule(ModuleGateway gateway) {
        return new DeleteModuleUseCaseImpl(gateway);
    }

    // Lesson Use Cases
    @Bean
    public CreateLessonUseCase createLesson(LessonGateway gateway) {
        return new CreateLessonUseCaseImpl(gateway);
    }

    @Bean
    public GetAllLessonsUseCase getAllLessons(LessonGateway gateway) {
        return new GetAllLessonsUseCaseImpl(gateway);
    }

    @Bean
    public GetLessonByIdUseCase getLessonById(LessonGateway gateway) {
        return new GetLessonByIdUseCaseImpl(gateway);
    }

    @Bean
    public UpdateLessonUseCase updateLesson(LessonGateway gateway) {
        return new UpdateLessonUseCaseImpl(gateway);
    }

    @Bean
    public DeleteLessonUseCase deleteLesson(LessonGateway gateway) {
        return new DeleteLessonUseCaseImpl(gateway);
    }

    // CourseCategorie Use Cases
    @Bean
    public CreateCourseCategorieUseCase createCourseCategorie(CourseCategorieGateway gateway) {
        return new CreateCourseCategorieUseCaseImpl(gateway);
    }

    @Bean
    public GetAllCourseCategoriesUseCase getAllCourseCategories(CourseCategorieGateway gateway) {
        return new GetAllCourseCategoriesUseCaseImpl(gateway);
    }

    @Bean
    public GetCourseCategorieByIdUseCase getCourseCategorieById(CourseCategorieGateway gateway) {
        return new GetCourseCategorieByIdUseCaseImpl(gateway);
    }

    @Bean
    public UpdateCourseCategorieUseCase updateCourseCategorie(CourseCategorieGateway gateway) {
        return new UpdateCourseCategorieUseCaseImpl(gateway);
    }

    @Bean
    public DeleteCourseCategorieUseCase deleteCourseCategorie(CourseCategorieGateway gateway) {
        return new DeleteCourseCategorieUseCaseImpl(gateway);
    }

    // StudentEnrollment Use Cases
    @Bean
    public CreateStudentEnrollmentUseCase createStudentEnrollment(StudentEnrollmentGateway gateway) {
        return new CreateStudentEnrollmentUseCaseImpl(gateway);
    }

    @Bean
    public GetAllStudentEnrollmentsUseCase getAllStudentEnrollments(StudentEnrollmentGateway gateway) {
        return new GetAllStudentEnrollmentsUseCaseImpl(gateway);
    }

    @Bean
    public GetStudentEnrollmentByIdUseCase getStudentEnrollmentById(StudentEnrollmentGateway gateway) {
        return new GetStudentEnrollmentByIdUseCaseImpl(gateway);
    }

    @Bean
    public UpdateStudentEnrollmentUseCase updateStudentEnrollment(StudentEnrollmentGateway gateway) {
        return new UpdateStudentEnrollmentUseCaseImpl(gateway);
    }

    @Bean
    public DeleteStudentEnrollmentUseCase deleteStudentEnrollment(StudentEnrollmentGateway gateway) {
        return new DeleteStudentEnrollmentUseCaseImpl(gateway);
    }
}
