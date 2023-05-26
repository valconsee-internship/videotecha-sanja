package com.project.videotecha.controller;

import com.project.videotecha.controller.api.ReservationControllerApi;
import com.project.videotecha.dto.ReservationCreationDto;
import com.project.videotecha.dto.ReservationDto;
import com.project.videotecha.mapper.ReservationMapper;
import com.project.videotecha.service.ReservationService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("reservations")
public class ReservationController implements ReservationControllerApi {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PreAuthorize("hasAuthority('ROLE_REGISTERED')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReservationDto create(@Valid @RequestBody ReservationCreationDto dto) {
        return ReservationMapper.mapToReservationDto(reservationService.create(dto));
    }

    @PreAuthorize("hasAuthority('ROLE_REGISTERED')")
    @PutMapping("/{id}/cancel")
    public void cancel(@PathVariable Long id) {
        reservationService.cancel(id);
    }
}
