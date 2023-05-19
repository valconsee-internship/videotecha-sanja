package com.project.videotecha.dto;

import java.time.LocalDateTime;

public class ProjectionCreationDto {
    private LocalDateTime start;
    private int ticketPrice;
    private Long movieId;
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
