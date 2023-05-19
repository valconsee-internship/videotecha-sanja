package com.project.videotecha.repository;

import com.project.videotecha.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {
    List<Projection> findByTheaterIdAndDeletedFalse(Long id);

    @Query("""
            SELECT p
            FROM Projection p
            WHERE p.deleted = false and
            p.availableSeats > 0
            """)
    List<Projection> findAvailableProjections();
}
