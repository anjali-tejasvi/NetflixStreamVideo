package com.netflix.content_service.controller;


import com.netflix.content_service.dto.MovieRequest;
import com.netflix.content_service.dto.MovieResponse;
import com.netflix.content_service.model.Genre;
import com.netflix.content_service.service.ContentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@Slf4j
@RequiredArgsConstructor
public class MovieController {

    private final ContentService contentService;

    // add movie to catalog
    @PostMapping
    public ResponseEntity<MovieResponse> addMovie(
            @Valid @RequestBody MovieRequest movieRequest
            ){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(contentService.addMovie(movieRequest));
    }


    //get all movies
    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies(){
        return ResponseEntity.ok(contentService.getAllMovies());
    }


    //get movies by genre
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieResponse>> getMoviesByGenre(
            @PathVariable Genre genre
            ){
        return ResponseEntity.ok(contentService.getMoviesByGenre(genre));
    }



    //get movies by id
    @GetMapping("/{movieId}")
    public ResponseEntity<MovieResponse> getMoviesById(
            @PathVariable String movieId
    ){
        return ResponseEntity.ok(contentService.getMoviesById(movieId));
    }


    @GetMapping("/search")
    public ResponseEntity<List<MovieResponse>> searchMovies(
            @RequestParam String title
    ){
        return ResponseEntity.ok(contentService.searchMovies(title));
    }



}
