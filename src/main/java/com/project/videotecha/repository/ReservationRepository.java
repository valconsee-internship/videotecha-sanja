package com.project.videotecha.repository;

import com.project.videotecha.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    @Query("""
             SELECT coalesce (sum(r.numberOfSeats), 0)
             FROM Reservation r
             WHERE r.canceled = False and
             r.user.id = :user_id and
             r.projection.id = :projection_id
            """)
    int sumNumberOfSeatsByUserIdAndProjectionId(@Param("user_id") Long userId, @Param("projection_id") Long projectionId);

    Optional<Reservation> findByIdAndCanceledFalse(Long id);
}
