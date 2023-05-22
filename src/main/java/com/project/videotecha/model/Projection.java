package com.project.videotecha.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Projection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;
    @ManyToOne(optional = false)
    @JoinColumn(name = "theater_id", nullable = false)
    private Theater theater;
    @NotNull(message = "Start time is required")
    private LocalDateTime start;
    @Min(value = 1)
    private int ticketPrice;
    private boolean deleted = false;
    @Min(value = 0)
    private int availableSeats;
    @OneToMany(mappedBy = "projection")
    private List<Reservation> reservations = new ArrayList<>();

    public Projection() {
    }

    public Projection(Long id, Movie movie, Theater theater, LocalDateTime start, int ticketPrice, boolean deleted) {
        this.id = id;
        this.movie = movie;
        this.theater = theater;
        this.start = start;
        this.ticketPrice = ticketPrice;
        this.deleted = deleted;
        this.availableSeats = theater.getCapacity();
    }

    public Projection(LocalDateTime start, int ticketPrice, Movie movie, Theater theater) {
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

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public LocalDateTime getEnd() {
        return this.start.plusMinutes(this.movie.getLength());
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
