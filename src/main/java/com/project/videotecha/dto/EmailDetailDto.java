package com.project.videotecha.dto;

public class EmailDetailDto {

    private String movieName;

    private String movieStartTime;

    private String userEmail;

    public EmailDetailDto(String movieName, String movieStartTime, String userEmail) {
        this.movieName = movieName;
        this.movieStartTime = movieStartTime;
        this.userEmail = userEmail;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getMovieStartTime() {
        return movieStartTime;
    }

    public String getUserEmail() {
        return userEmail;
    }
}
