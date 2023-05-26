package com.project.videotecha.controller;

import com.project.videotecha.controller.api.ReservationControllerApi;
import com.project.videotecha.dto.ReservationCreationDto;
import com.project.videotecha.dto.ReservationDto;
import com.project.videotecha.mapper.ReservationMapper;
import com.project.videotecha.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reservations")
public class ReservationController implements ReservationControllerApi {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationDto create(@Valid @RequestBody ReservationCreationDto dto) {
        return ReservationMapper.mapToReservationDto(reservationService.create(dto));
    }

    @PutMapping("/{id}/cancel")
    public void cancel(@PathVariable Long id) {
        reservationService.cancel(id);
    }
}
