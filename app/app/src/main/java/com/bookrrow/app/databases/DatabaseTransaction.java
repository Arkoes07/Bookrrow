package com.bookrrow.app.databases;

import com.bookrrow.app.exceptions.BookAlreadyExistsException;
import com.bookrrow.app.models.Transaction;

import java.util.ArrayList;

public class DatabaseTransaction {
    private static final ArrayList<Transaction> TRANSACTION_DATABASE = new ArrayList<>();
    private static int LAST_TRANSACTION_ID = 0;

    public static int getLastTransactionId() {
        return LAST_TRANSACTION_ID;
    }

    public static boolean addTransaction(Transaction transaction) throws BookAlreadyExistsException {
        TRANSACTION_DATABASE.add(transaction);
        LAST_TRANSACTION_ID = transaction.getTransaction_id();
        return true;
    }

    public static Transaction getTransactionFromId(int transaction_id){
        for(Transaction t : TRANSACTION_DATABASE){
            if(t.getTransaction_id() == transaction_id){
                return t;
            }
        }
        return null;
    }
}
