package com.project.videotecha.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ProjectionCreationDto {
    @Future(message = "Projection must be in the future")
    @NotNull(message = "Projection start time is required")
    private LocalDateTime start;
    @Min(value = 1)
    private int ticketPrice;
    @NotNull(message = "Movie is required")
    private Long movieId;
    @NotNull(message = "Theater is required")
    private Long theaterId;

    public ProjectionCreationDto() {
    }

    public ProjectionCreationDto(LocalDateTime start, int ticketPrice, Long movieId, Long theaterId) {
        this.start = start;
        this.ticketPrice = ticketPrice;
        this.movieId = movieId;
        this.theaterId = theaterId;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public void setTheaterId(Long theaterId) {
        this.theaterId = theaterId;
    }
}
