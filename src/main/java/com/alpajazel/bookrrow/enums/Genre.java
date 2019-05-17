package com.alpajazel.bookrrow.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Enum class for specifying genre of a book
 *
 * @author M. Alwi Sukra
 * @version 1.0
 * @since 2019-05-17
 */
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

    /**
     * constructor for assign value of book genre and the key name
     *
     * @param genre value of the enum
     * @param keyName key name of the enum
     */
    Genre(String genre, String keyName) {
        this.genre = genre;
        this.keyName = keyName;
    }

    /**
     * get the value of an enum
     *
     * @return the enum value
     */
    public String getGenre() {
        return genre;
    }

    /**
     * get the key name of an enum
     *
     * @return the enum key name
     */
    public String getKeyName() {
        return keyName;
    }
}
