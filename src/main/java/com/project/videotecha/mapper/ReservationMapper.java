package com.project.videotecha.mapper;

import com.project.videotecha.dto.ReservationDto;
import com.project.videotecha.model.Projection;
import com.project.videotecha.model.Reservation;
import com.project.videotecha.model.User;

public class ReservationMapper {
    private ReservationMapper() {
    }

    public static ReservationDto mapToReservationDto(Reservation reservation) {
        ReservationDto dto = new ReservationDto();
        dto.setId(reservation.getId());
        dto.setProjection(ProjectionMapper.mapProjectionToProjectionDto(reservation.getProjection()));
        dto.setUser(UserMapper.mapUserToUserDto(reservation.getUser()));
        dto.setNumberOfSeats(reservation.getNumberOfSeats());
        return dto;
    }

    public static Reservation mapToReservation(User user, Projection projection, Integer numberOfSeats) {
        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setProjection(projection);
        reservation.setNumberOfSeats(numberOfSeats);
        return reservation;
    }
}
