package com.alpajazel.bookrrow.exceptions;

public class BookNotFoundException extends Exception{
    private int book_error;
    public BookNotFoundException(int book_input) {
        super("Book ID: ");
        this.book_error = book_input;
    }

    public String getExMessage(){
        return  "===============ITEM NOT FOUND===============\n"+super.getMessage()+book_error+" not found.\n\n";
    }
}
