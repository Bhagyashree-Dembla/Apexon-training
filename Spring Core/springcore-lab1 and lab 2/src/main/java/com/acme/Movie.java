package com.acme;

public class Movie {
    private String movieId;
    private String movieName;
    private String movieActor;

    public Movie() {}

    public String getMovieId() { return movieId; }
    public void setMovieId(String movieId) { this.movieId = movieId; }

    public String getMovieName() { return movieName; }
    public void setMovieName(String movieName) { this.movieName = movieName; }

    public String getMovieActor() { return movieActor; }
    public void setMovieActor(String movieActor) { this.movieActor = movieActor; }

    public void display() {
        System.out.println("Movie Id   : " + movieId);
        System.out.println("Movie Name : " + movieName);
        System.out.println("Movie Actor: " + movieActor);
    }
}
