package com.project.videotecha.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ReservationCreationDto {
    @NotNull(message = "Projection is required")
    private Long projectionId;
    @NotNull(message = "User is required")
    private Long userId;
    @Min(value = 1)
    private int numberOfSeats;

    public ReservationCreationDto() {
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public void setProjectionId(Long projectionId) {
        this.projectionId = projectionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
