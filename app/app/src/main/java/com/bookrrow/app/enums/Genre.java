package com.bookrrow.app.enums;

public enum Genre {
    HORROR("Horror"),
    FANTASY("Fantasy"),
    ROMANCE("Romance"),
    SLICEOFLIFE("Slice of Life"),
    COMEDY("Comedy"),
    SCIFI("Sci-fi"),
    ADULT("Adult"),
    MYSTERY("Mystery");

    private String genre;

    Genre(String genre) {
        this.genre = genre;
    }

    public String toString(){
        return genre;
    }
}
