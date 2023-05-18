package com.project.videotecha.service;

import com.project.videotecha.dto.ReservationCreationDto;
import com.project.videotecha.model.Reservation;

public interface ReservationService {
    Reservation create(ReservationCreationDto dto);
}
