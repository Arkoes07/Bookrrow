package com.alpajazel.bookrrow.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BookStatus {
    AVAILABLE("Fiction", "AVAILABLE"),
    NOTAVAILABLE("Not-Available", "NOTAVAILABLE");

    private String bookStatus;
    private String keyName;

    BookStatus(String bookStatus, String keyName) {
        this.bookStatus = bookStatus;
        this.keyName = keyName;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public String getKeyName() {
        return keyName;
    }
}
