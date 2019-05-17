package com.alpajazel.bookrrow.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Enum class for specifying status of a book
 *
 * available  : book is available to be borrowed by others
 * not-available : book is borrowed and not available for other to borrow it
 *
 * @author M. Alwi Sukra
 * @version 1.0
 * @since 2019-05-17
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum BookStatus {
    AVAILABLE("Available", "AVAILABLE"),
    NOTAVAILABLE("Not-Available", "NOTAVAILABLE");

    private String bookStatus;
    private String keyName;

    /**
     * constructor for assign value of book status and the key name
     *
     * @param bookStatus value of the enum
     * @param keyName key name of the enum
     */
    BookStatus(String bookStatus, String keyName) {
        this.bookStatus = bookStatus;
        this.keyName = keyName;
    }

    /**
     * get the value of an enum
     *
     * @return the enum value
     */
    public String getBookStatus() {
        return bookStatus;
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
