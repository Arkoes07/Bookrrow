package com.alpajazel.bookrrow.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Language {
    ENGLISH("English", "ENGLISH"),
    INDONESIAN("Indonesian", "INDONESIAN"),
    SPANISH("Spanish", "SPANISH"),
    JAPANESE("Japanese", "JAPANESE");

    private String language;
    private String keyName;

    Language(String language, String keyName) {
        this.language = language;
        this.keyName = keyName;
    }

    public String getLanguage() {
        return language;
    }

    public String getKeyName() {
        return keyName;
    }
}
