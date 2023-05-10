package com.project.videotecha.repository;

import com.project.videotecha.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    Optional<Movie> findByIdAndDeletedFalse(Long id);
}
