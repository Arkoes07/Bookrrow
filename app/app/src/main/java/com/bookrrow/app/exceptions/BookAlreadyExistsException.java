package com.bookrrow.app.exceptions;

import com.bookrrow.app.models.Book;

public class BookAlreadyExistsException extends Exception {
    private Book book_error;

    public BookAlreadyExistsException(Book book_input) {
        super("Book name: ");
        this.book_error = book_input;
    }

    public String getExMessage(){
        return super.getMessage()+book_error.getTitle()+book_error.getSubtitle()+"by "+book_error.getUser()+"already exists.\n\n";
    }
}
