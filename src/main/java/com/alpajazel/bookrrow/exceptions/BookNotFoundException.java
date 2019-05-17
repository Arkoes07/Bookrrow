package com.alpajazel.bookrrow.exceptions;

/**
 * Exception class that thrown to notify that the Book is not found
 *
 * @author M. Alwi Sukra
 * @version 1.0.0
 * @since 2019-05-16
 */
public class BookNotFoundException extends Exception{
    private int book_error;

    /**
     * Constructor for this exception class
     *
     * @param book_input id of the book that doesn't exist or not found
     * @since 2019-05-16
     */
    public BookNotFoundException(int book_input) {
        super("Book ID: ");
        this.book_error = book_input;
    }

    /**
     * Generate meaningful error message
     *
     * @return meaningful error message
     * @since 2019-05-16
     */
    public String getExMessage(){
        return  "===============ITEM NOT FOUND===============\n"+super.getMessage()+book_error+" not found.\n\n";
    }
}
