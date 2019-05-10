package com.alpajazel.bookrrow.controller;

import com.alpajazel.bookrrow.databases.DatabaseTransaction;
import com.alpajazel.bookrrow.models.Transaction;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    DatabaseTransaction dt = new DatabaseTransaction();

    @RequestMapping(value="/borrow", method = RequestMethod.POST)
    public Transaction borrow(@RequestParam(value="book_id") int book_id,
                              @RequestParam(value="borrower_id") int borrower_id
    ) {
        dt.connect();
        Transaction transaction = dt.borrow(book_id, borrower_id);
        dt.disconnect();
        return transaction;
    }

    @RequestMapping(value="/incomingrequest/{id}", method = RequestMethod.GET)
    public ArrayList<Transaction> getIncomingRequest (@PathVariable int id){
        ArrayList<Transaction> transactions = new ArrayList<>();
        dt.connect();
        try {
            transactions = dt.getIncomingRequest(id);
            return transactions;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        dt.disconnect();
        return transactions;
    }

    @RequestMapping(value = "/outgoingrequest/{id}", method = RequestMethod.GET)
    public ArrayList<Transaction> getOutgoingRequest(@PathVariable int id) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        dt.connect();
        transactions = dt.getOutgoingRequest(id);
        dt.disconnect();
        return transactions;
    }

    @RequestMapping(value = "/borrowed/{id}", method = RequestMethod.GET)
    public ArrayList<Transaction> getIncomingOngoing (@PathVariable int id) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        dt.connect();
        transactions = dt.getIncomingOngoing(id);
        dt.disconnect();
        return transactions;
    }

    @RequestMapping(value = "/borrowing/{id}", method = RequestMethod.GET)
    public ArrayList<Transaction> getOutgoingOngoing (@PathVariable int id) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        dt.connect();
        transactions = dt.getOutgoingOngoing(id);
        dt.disconnect();
        return transactions;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Transaction getTransaction(@PathVariable int id) {
        dt.connect();
        Transaction transaction = dt.getTransaction(id);
        dt.disconnect();
        return transaction;
    }

    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public Transaction reject(@RequestParam(value = "transaction_id") int transaction_id){
        dt.connect();
        Transaction transaction = dt.reject(transaction_id);
        dt.disconnect();
        return transaction;
    }

    @RequestMapping(value = "/accept", method = RequestMethod.POST)
    public Transaction accept(@RequestParam(value = "transaction_id") int transaction_id){
        dt.connect();
        Transaction transaction = dt.accept(transaction_id);
        dt.disconnect();
        return transaction;
    }

    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public Transaction finish(@RequestParam(value = "transaction_id") int transaction_id){
        dt.connect();
        Transaction transaction = dt.finish(transaction_id);
        dt.disconnect();
        return transaction;
    }

    @RequestMapping(value="/outgoinghistory/{borrower_id}", method = RequestMethod.GET)
    public ArrayList<Transaction> getOutgoingHistory (@PathVariable int borrower_id){
        ArrayList<Transaction> transactions = new ArrayList<>();
        dt.connect();
        transactions = dt.getOutgoingHistory(borrower_id);
        dt.disconnect();
        return transactions;
    }

}
