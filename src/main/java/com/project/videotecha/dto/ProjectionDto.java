package com.project.videotecha.dto;

import java.time.LocalDateTime;

public class ProjectionDto {
    private Long id;
    private MovieDto movie;
    private TheaterDto theater;
    private LocalDateTime start;
    private int ticketPrice;
    private int availableSeats;

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

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}
