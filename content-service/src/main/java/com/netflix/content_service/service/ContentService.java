package com.netflix.content_service.service;

import com.netflix.content_service.dto.MovieRequest;
import com.netflix.content_service.dto.MovieResponse;
import com.netflix.content_service.model.Movie;
import com.netflix.content_service.model.VideoStatus;
import com.netflix.content_service.repository.ContentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContentService {

    private final ContentRepository contentRepository;

    /*
        add a new movie to the catalog
        video is not uploaded yet at this stage
     */
    public MovieResponse addMovie(MovieRequest request) {

        log.info("Adding new movie {}", request.getTitle());

        Movie movie = Movie.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .genre(request.getGenre())
                .director(request.getDirector())
                .caste(request.getCaste())
                .releaseYear(request.getReleaseYear())
                .rating(request.getRating())
                .thumbnailUrl(request.getThumbnailUrl())
                .durationMinutes(request.getDurationMinutes())
                .videoStatus(VideoStatus.PENDING)
                .build();

        Movie savedMovie = contentRepository.save(movie);

        log.info("Movie added to repository {}", savedMovie);

        return mapToResponse(savedMovie);
    }

    /*
        get all movies from the catalog
     */
    public List<MovieResponse> getAllMovies() {

        return contentRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    /*
        convert Movie entity to MovieResponse DTO
     */
    private MovieResponse mapToResponse(Movie movie) {

        return MovieResponse.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .description(movie.getDescription())
                .genre(movie.getGenre())
                .director(movie.getDirector())
                .caste(movie.getCaste())
                .releaseYear(movie.getReleaseYear())
                .rating(movie.getRating())
                .thumbnailUrl(movie.getThumbnailUrl())
                .durationMinutes(movie.getDurationMinutes())
                .videoStatus(movie.getVideoStatus())
                .hlsUrl(movie.getHlsUrl())
                .createdAt(movie.getCreatedAt())
                .build();
    }
}