package com.project.videotecha.repository;

import com.project.videotecha.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {
    List<Projection> findByTheaterIdAndDeletedFalse(Long id);
}
