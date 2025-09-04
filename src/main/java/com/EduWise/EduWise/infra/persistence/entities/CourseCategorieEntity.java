package com.EduWise.EduWise.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "COURSE_CATEGORIES")
public class CourseCategorieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @CreationTimestamp
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COURSE_ID")
    private CourseEntity courseEntity;
}
