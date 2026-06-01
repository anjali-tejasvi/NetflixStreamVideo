package com.netflix.content_service.dto;

import com.netflix.content_service.model.Genre;
import com.netflix.content_service.model.VideoStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jdk.jshell.Snippet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {
    private String id;
    private String title;
    private String description;
    private Genre genre;
    private String director;
    private String caste;
    private String releaseYear;
    private double rating;
    private String thumbnailUrl;
    private String durationMinutes;
    private String hlsUrl;
    private VideoStatus videoStatus;
    private LocalDateTime createdAt;


}
