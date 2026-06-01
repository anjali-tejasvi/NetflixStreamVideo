package com.netflix.content_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Movie {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(nullable = false)
    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String director;
    private String caste;
    private String releaseYear;

    private double rating;
    private String thumbnailUrl;
    private String durationMinutes;

    //s3 key for video file
    private String videoKey;

    //hls master playlist for streaming
    private String hlsUrl;

    //status of video processing
    @Enumerated(EnumType.STRING)
    private VideoStatus videoStatus;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
