package com.alpajazel.bookrrow.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Enum class for specifying language of a book
 *
 * @author M. Alwi Sukra
 * @version 1.0
 * @since 2019-05-17
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Language {
    ENGLISH("English", "ENGLISH"),
    INDONESIAN("Indonesian", "INDONESIAN"),
    SPANISH("Spanish", "SPANISH"),
    JAPANESE("Japanese", "JAPANESE");

    private String language;
    private String keyName;

    /**
     * constructor for assign value of book language and the key name
     *
     * @param language value of the enum
     * @param keyName key name of the enum
     */
    Language(String language, String keyName) {
        this.language = language;
        this.keyName = keyName;
    }

    /**
     * get the value of an enum
     *
     * @return the enum value
     */
    public String getLanguage() {
        return language;
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
