package com.project.videotecha.dto;

import com.project.videotecha.model.Projection;

import java.time.LocalDateTime;

public class ProjectionDto {
    private Long id;
    private MovieDto movie;
    private TheaterDto theater;
    private LocalDateTime start;
    private Integer ticketPrice;

    public ProjectionDto() {
    }

    public ProjectionDto(Projection p) {
        this.id = p.getId();
        this.start = p.getStart();
        this.ticketPrice = p.getTicketPrice();
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
}