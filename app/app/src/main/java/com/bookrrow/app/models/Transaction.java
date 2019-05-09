package com.bookrrow.app.models;

import com.bookrrow.app.databases.DatabaseTransaction;

public class Transaction {
    private int transaction_id;
    private Book book;
    private User user;

    public Transaction(Book book, User user) {
        this.transaction_id = DatabaseTransaction.getLastTransactionId()+1;
        this.book = book;
        this.user = user;
        this.book.setStatus(false);
    }

    public void returnBook(){
        this.book.setStatus(true);
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public Book getTransactionBook() {
        return book;
    }

    public User getTransactionUser() {
        return user;
    }

}
