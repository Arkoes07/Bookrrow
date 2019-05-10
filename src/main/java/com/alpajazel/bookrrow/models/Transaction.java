package com.alpajazel.bookrrow.models;

import com.alpajazel.bookrrow.enums.TransactionStatus;

import java.util.Calendar;

public class Transaction {
    private int id;
    private Book book;
    private Consumer borrower;
    private TransactionStatus transactionStatus;
    private Calendar requestDate;
    private Calendar finishDate;
    private Calendar borrowerDate;

    public Transaction(int id, Book book, Consumer borrower) {
        this.id = id;
        this.book = book;
        this.borrower = borrower;
    }

    public Transaction(int id, Book book, Consumer borrower, TransactionStatus transactionStatus, Calendar requestDate, Calendar finishDate, Calendar borrowerDate) {
        this.id = id;
        this.book = book;
        this.borrower = borrower;
        this.transactionStatus = transactionStatus;
        this.requestDate = requestDate;
        this.finishDate = finishDate;
        this.borrowerDate = borrowerDate;
    }

    public int getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public Consumer getBorrower() {
        return borrower;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public Calendar getRequestDate() {
        return requestDate;
    }

    public Calendar getFinishDate() {
        return finishDate;
    }

    public Calendar getBorrowerDate() {
        return borrowerDate;
    }
}
