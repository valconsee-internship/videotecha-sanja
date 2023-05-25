package com.project.videotecha.service.impl;

import com.project.videotecha.dto.ReservationCreationDto;
import com.project.videotecha.exception.BusinessRuleException;
import com.project.videotecha.exception.EntityNotFoundException;
import com.project.videotecha.exception.NoAvailableSeatsException;
import com.project.videotecha.mapper.ReservationMapper;
import com.project.videotecha.model.Projection;
import com.project.videotecha.model.Reservation;
import com.project.videotecha.model.User;
import com.project.videotecha.repository.ReservationRepository;
import com.project.videotecha.service.ProjectionService;
import com.project.videotecha.service.ReservationService;
import com.project.videotecha.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static java.lang.String.format;

@Service
public class ReservationServiceImpl implements ReservationService {
    private static final Logger logger = LoggerFactory.getLogger(ReservationServiceImpl.class);
    private static final int MAX_NUMBER_OF_SEATS_PER_RESERVATION = 5;
    private static final int CANCELLING_RESERVATION_LIMIT_IN_HOURS = 2;
    private final ReservationRepository reservationRepository;
    private final ProjectionService projectionService;
    private final UserService userService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ProjectionService projectionService, UserService userService) {
        this.reservationRepository = reservationRepository;
        this.projectionService = projectionService;
        this.userService = userService;
    }

    @Override
    @Transactional
    public Reservation create(ReservationCreationDto dto) {
        // TODO: problem kada pristignu dva konkurenta zahteva, potrebno je implementirati zakljucavanje resursa
        if (dto.getNumberOfSeats() > MAX_NUMBER_OF_SEATS_PER_RESERVATION) {
            throw new BusinessRuleException("Max number of reserved tickets for one projection has been exceeded");
        }
        int numberOfSeatsByUserIdAndProjectionId =
                reservationRepository.sumNumberOfSeatsByUserIdAndProjectionId(dto.getUserId(), dto.getProjectionId());
        if (numberOfSeatsByUserIdAndProjectionId + dto.getNumberOfSeats() > MAX_NUMBER_OF_SEATS_PER_RESERVATION) {
            throw new BusinessRuleException(format("Max number of reserved tickets for projection with ID %d has been " +
                    "exceeded", dto.getProjectionId()));
        }
        Projection projection = projectionService.getById(dto.getProjectionId());
        if (projection.getAvailableSeats() < dto.getNumberOfSeats()) {
            throw new NoAvailableSeatsException(format("No available seats for projection with ID %d", projection.getId()));
        }
        User user = userService.getById(dto.getUserId());
        Reservation reservation = ReservationMapper.mapToReservation(user, projection, dto.getNumberOfSeats());
        reservation.getProjection().setAvailableSeats(reservation.getProjection().getAvailableSeats() - dto.getNumberOfSeats());
        logger.info("Creating reservation for user (Id = {}), on projection (Id = {}).",dto.getUserId(),dto.getProjectionId());
        return reservationRepository.save(reservation);
    }

    @Override
    @Transactional
    public void cancel(Long id) {
        Reservation r = getById(id);
        LocalDateTime reservationDeadline = r.getProjection().getStart().minusHours(CANCELLING_RESERVATION_LIMIT_IN_HOURS);
        if (reservationDeadline.isBefore(LocalDateTime.now())) {
            throw new BusinessRuleException(
                    format("User cannot cancel reservation up-to %s hours", CANCELLING_RESERVATION_LIMIT_IN_HOURS));
        }
        r.setCanceled(true);
        int availableSeatsAfterCanceling = r.getProjection().getAvailableSeats() + r.getNumberOfSeats();
        r.getProjection().setAvailableSeats(availableSeatsAfterCanceling);
        logger.info("Canceling reservation(Id={}) for user (Id={}) on projection(Id={}).",r.getId(),r.getUser().getId(),r.getProjection().getId());
        reservationRepository.save(r);
    }

    private Reservation getById(Long id) {
        return reservationRepository.findByIdAndCanceledFalse(id).orElseThrow(() ->
                new EntityNotFoundException(format("Not found reservation with ID %s", id)));
    }
}
