package com.alpajazel.bookrrow.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Enum class for specifying type of a book
 *
 * @author M. Alwi Sukra
 * @version 1.0
 * @since 2019-05-17
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BookType {
    FICTION("Fiction", "FICTION"),
    NONFICTION("Non-fiction", "NONFICTION");

    private String bookType;
    private String keyName;

    /**
     * constructor for assign value of book type and the key name
     *
     * @param bookType value of the enum
     * @param keyName key name of the enum
     */
    BookType(String bookType, String keyName) {
        this.bookType = bookType;
        this.keyName = keyName;
    }

    /**
     * get the value of an enum
     *
     * @return the enum value
     */
    public String getBookType() {
        return bookType;
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
