package com.alpajazel.bookrrow.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BookType {
    FICTION("Fiction", "FICTION"),
    NONFICTION("Non-fiction", "NONFICTION");

    private String bookType;
    private String keyName;

    BookType(String bookType, String keyName) {
        this.bookType = bookType;
        this.keyName = keyName;
    }

    public String getBookType() {
        return bookType;
    }

    public String getKeyName() {
        return keyName;
    }
}
