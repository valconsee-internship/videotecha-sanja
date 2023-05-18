package com.project.videotecha.controller;

import com.project.videotecha.dto.ReservationCreationDto;
import com.project.videotecha.dto.ReservationDto;
import com.project.videotecha.mapper.ReservationMapper;
import com.project.videotecha.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationDto create(@RequestBody ReservationCreationDto dto) {
        return ReservationMapper.mapToReservationDto(reservationService.create(dto));
    }
}
