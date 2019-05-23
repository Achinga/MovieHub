package com.dsc.jkuat.moviehub.model;

import java.util.Objects;


public final class Movie {

    private String title;
    private String ratings;
    private int movieId;

    public Movie(String title, String ratings) {
        this.title = title;
        this.ratings = ratings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", ratings='" + ratings + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object vo) {
        if (this == vo) return true;
        if (vo == null || getClass() != vo.getClass()) return false;
        Movie vvMovie = (Movie) vo;
        return getMovieId() == vvMovie.getMovieId() &&
                getTitle().equals(vvMovie.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getMovieId());
    }
}
