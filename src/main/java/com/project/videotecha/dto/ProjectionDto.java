package com.project.videotecha.dto;

import java.time.LocalDateTime;

public class ProjectionDto {
    private Long id;
    private MovieDto movie;
    private TheaterDto theater;
    private LocalDateTime start;
    private Integer ticketPrice;
    private Integer availableSeats;

    public ProjectionDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MovieDto getMovie() {
        return movie;
    }

    public void setMovie(MovieDto movie) {
        this.movie = movie;
    }

    public TheaterDto getTheater() {
        return theater;
    }

    public void setTheater(TheaterDto theater) {
        this.theater = theater;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Integer ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }
}
