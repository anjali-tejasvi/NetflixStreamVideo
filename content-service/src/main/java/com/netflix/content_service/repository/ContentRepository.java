package com.netflix.content_service.repository;

import com.netflix.content_service.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository  extends JpaRepository<Movie,String> {
}
