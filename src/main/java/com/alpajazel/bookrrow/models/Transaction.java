package com.alpajazel.bookrrow.models;

public class Transaction {
    private int id;
    private Book book;
    private Consumer borrower;

    public Transaction(int id, Book book, Consumer borrower) {
        this.id = id;
        this.book = book;
        this.borrower = borrower;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Consumer getBorrower() {
        return borrower;
    }

    public void setBorrower(Consumer borrower) {
        this.borrower = borrower;
    }
}
