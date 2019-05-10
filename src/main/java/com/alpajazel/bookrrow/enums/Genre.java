package com.alpajazel.bookrrow.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Genre {
    HORROR("Horror", "HORROR"),
    FANTASY("Fantasy", "FANTASY"),
    ROMANCE("Romance", "ROMANCE"),
    SLICEOFLIFE("Slice of Life", "SLICEOFLIFE"),
    COMEDY("Comedy", "COMEDY"),
    SCIFI("Sci-fi", "SCIFI"),
    ADULT("Adult", "ADULT"),
    MYSTERY("Mystery", "MYSTERY");

    private String genre;
    private String keyName;

    Genre(String genre, String keyName) {
        this.genre = genre;
        this.keyName = keyName;
    }

    public String getGenre() {
        return genre;
    }

    public String getKeyName() {
        return keyName;
    }
}
