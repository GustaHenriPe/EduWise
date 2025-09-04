package com.EduWise.EduWise.infra.persistence.entities;

import com.EduWise.EduWise.core.enums.ContentType;
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
@Table(name = "LESSONS")
public class LessonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "TITLE", nullable = false)
    String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONTENT_TYPE", nullable = false)
    ContentType contentType;

    @Column(name = "VIDEO_URL")
    String videoUrl;

    @Column(name = "TEXT_CONTENT")
    String textContent;

    @CreationTimestamp
    @Column(name = "CREATED_AT")
    LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "UPDATED_AT")
    LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MODULE_ID")
    ModuleEntity moduleEntity;

}
