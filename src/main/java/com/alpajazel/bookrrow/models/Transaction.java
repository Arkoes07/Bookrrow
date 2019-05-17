package com.alpajazel.bookrrow.models;

import com.alpajazel.bookrrow.enums.TransactionStatus;

import java.util.Calendar;

/**
 * represent a transaction between user
 *
 * @author DP Nala Krisnanda
 * @version 1.0
 * @since 2019-05-17
 */
public class Transaction {
    private int id;
    private Book book;
    private Consumer borrower;
    private TransactionStatus transactionStatus;
    private Calendar requestDate;
    private Calendar finishDate;
    private Calendar startDate;

    /**
     * constructor used when generating a new transaction
     * @param id of the transaction
     * @param book book involved in the transaction
     * @param borrower is the consumer which borrow the book
     */
    public Transaction(int id, Book book, Consumer borrower) {
        this.id = id;
        this.book = book;
        this.borrower = borrower;
    }

    /**
     * constructor used when getting transaction from the database
     * @param id of the transaction
     * @param book involved in the transaction
     * @param borrower is a consumer which borrow the book
     * @param transactionStatus is status of the transaction
     * @param requestDate is when the transaction enter the pending status
     * @param startDate is when the transaction enter ongoing status
     * @param finishDate is when the transaction enter the finish status
     */
    public Transaction(int id, Book book, Consumer borrower, TransactionStatus transactionStatus, Calendar requestDate, Calendar startDate, Calendar finishDate) {
        this.id = id;
        this.book = book;
        this.borrower = borrower;
        this.transactionStatus = transactionStatus;
        this.requestDate = requestDate;
        this.finishDate = finishDate;
        this.startDate = startDate;
    }

    /**
     * get the id of a transaction
     * @return the id of a transaction
     */
    public int getId() {
        return id;
    }

    /**
     * get the book involved in a transaction
     * @return the book involved in a transaction
     */
    public Book getBook() {
        return book;
    }

    /**
     * get a customer which borrow the book
     * @return a customer which borrow the book
     */
    public Consumer getBorrower() {
        return borrower;
    }

    /**
     * get the status of a transaction
     * @return the status of a transaction
     */
    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    /**
     * get the date when a transaction enter the pending status
     * @return the date when a transaction enter the pending status
     */
    public Calendar getRequestDate() {
        return requestDate;
    }

    /**
     * get the date when a transaction enter the ongoing status
     * @return the date when a transaction enter the ongoing status
     */
    public Calendar getFinishDate() {
        return finishDate;
    }

    /**
     * get the date when a transaction enter the finished status
     * @return the date when a transaction enter the finished status
     */
    public Calendar getStartDate() {
        return startDate;
    }
}
