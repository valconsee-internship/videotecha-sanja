package com.project.videotecha.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

@Entity
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    @ManyToOne(optional = false)
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;
    private LocalDateTime start;
    private Integer ticketPrice;
    private Boolean deleted = false;
    private Integer availableSeats;

    public Projection() {
    }

    public Projection(Long id, Movie movie, Theater theater, LocalDateTime start, Integer ticketPrice, Boolean deleted) {
        this.id = id;
        this.movie = movie;
        this.theater = theater;
        this.start = start;
        this.ticketPrice = ticketPrice;
        this.deleted = deleted;
        this.availableSeats = theater.getCapacity();
    }

    public Projection(LocalDateTime start, Integer ticketPrice, Movie movie, Theater theater) {
        this.start = start;
        this.ticketPrice = ticketPrice;
        this.movie = movie;
        this.theater = theater;
        this.availableSeats = theater.getCapacity();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theater getTheater() {
        return theater;
    }

    public void setTheater(Theater theater) {
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

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public LocalDateTime getEnd() {
        return this.start.plusMinutes(this.movie.getLength());
    }
}
