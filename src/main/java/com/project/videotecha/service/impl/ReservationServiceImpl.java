package com.project.videotecha.service.impl;

import com.project.videotecha.dto.ReservationCreationDto;
import com.project.videotecha.mapper.ReservationMapper;
import com.project.videotecha.model.Projection;
import com.project.videotecha.model.Reservation;
import com.project.videotecha.model.User;
import com.project.videotecha.repository.ReservationRepository;
import com.project.videotecha.service.ProjectionService;
import com.project.videotecha.service.ReservationService;
import com.project.videotecha.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {
    private static final Integer MAX_NUMBER_OF_SEATS_PER_RESERVATION = 5;
    private final ReservationRepository reservationRepository;
    private final ProjectionService projectionService;
    private final UserService userService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ProjectionService projectionService, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.projectionService = projectionService;
        this.userService = userService;
    }

    @Override
    public Reservation create(ReservationCreationDto dto) {
        // TODO: problem kada pristignu dva konkurenta zahteva, potrebno je implementirati zakljucavanje resursa
        if (dto.getNumberOfSeats() > MAX_NUMBER_OF_SEATS_PER_RESERVATION) {
            throw new RuntimeException("Max number of reserved tickets for one projection has been exceeded");
        }
        Integer numberOfSeatsByUserIdAndProjectionId =
                reservationRepository.sumNumberOfSeatsByUserIdAndProjectionId(dto.getUserId(), dto.getProjectionId());
        if (numberOfSeatsByUserIdAndProjectionId + dto.getNumberOfSeats() > MAX_NUMBER_OF_SEATS_PER_RESERVATION) {
            throw new RuntimeException(String.format("Max number of reserved tickets for projection with ID %d has " +
                    "been exceeded", dto.getProjectionId()));
        }
        Projection projection = projectionService.getById(dto.getProjectionId());
        if (projection.getAvailableSeats() < dto.getNumberOfSeats()) {
            throw new RuntimeException("No available seats for projection with ID " + projection.getId());
        }
        User user = userService.getById(dto.getUserId());
        Reservation reservation = ReservationMapper.mapToReservation(user, projection, dto.getNumberOfSeats());
        reservation.getProjection().setAvailableSeats(reservation.getProjection().getAvailableSeats() - dto.getNumberOfSeats());
        return reservationRepository.save(reservation);
    }
}
