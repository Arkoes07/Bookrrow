package com.alpajazel.bookrrow.controller;

import com.alpajazel.bookrrow.databases.DatabaseTransaction;
import com.alpajazel.bookrrow.models.Transaction;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * controller class which handle the web request
 * this class is related to the DatabaseTransaction class
 *
 * @author DP Nala Krisnanda
 * @version 1.0
 * @since 2019-05-17
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    DatabaseTransaction dt = new DatabaseTransaction();

    /**
     * map the borrow method in DatabaseTransaction class to the /transaction/borrow address
     * @param book_id is the id of book involved in the transaction
     * @param borrower_id is the if of customer having a role as borrower in the transaction
     * @return the transaction inserted to the database
     */
    @RequestMapping(value="/borrow", method = RequestMethod.POST)
    public Transaction borrow(@RequestParam(value="book_id") int book_id,
                              @RequestParam(value="borrower_id") int borrower_id
    ) {
        dt.connect();
        Transaction transaction = dt.borrow(book_id, borrower_id);
        dt.disconnect();
        return transaction;
    }

    /**
     * map the getIncomingRequest method in the DatabaseTransaction class to the /transaction/incomingrequest/{id} address
     * @param id is the consumer id which owned the book
     * @return list of transactions with status pending which book involved is owned by specified consumer id
     */
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

    /**
     * map the getOutgoingRequest method in the DatabaseTransaction class to the /transaction/outgoingrequest/{id} address
     * @param id is the consumer id which owned the book
     * @return list of transactions with status ongoing which book involved is owned by specified consumer id
     */
    @RequestMapping(value = "/outgoingrequest/{id}", method = RequestMethod.GET)
    public ArrayList<Transaction> getOutgoingRequest(@PathVariable int id) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        dt.connect();
        transactions = dt.getOutgoingRequest(id);
        dt.disconnect();
        return transactions;
    }

    /**
     * map the getIncomingOngoing method in the DatabaseTransaction class to the /transaction/borrowed/{id} address
     * @param id is the consumer id which have a role as borrower in the transaction database
     * @return all transactions with status ongoing which the borrower id is equal to specified consumer id
     */
    @RequestMapping(value = "/borrowed/{id}", method = RequestMethod.GET)
    public ArrayList<Transaction> getIncomingOngoing (@PathVariable int id) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        dt.connect();
        transactions = dt.getIncomingOngoing(id);
        dt.disconnect();
        return transactions;
    }

    /**
     * map the getOutgoingOngoing method in the DatabaseTransaction class to the /transaction/borrowing/{id} address
     * @param id is the consumer id which owned the book
     * @return all transactions with status rejected or finished which book involved is owned by specified consumer id
     */
    @RequestMapping(value = "/borrowing/{id}", method = RequestMethod.GET)
    public ArrayList<Transaction> getOutgoingOngoing (@PathVariable int id) {
        ArrayList<Transaction> transactions = new ArrayList<>();
        dt.connect();
        transactions = dt.getOutgoingOngoing(id);
        dt.disconnect();
        return transactions;
    }


    /**
     * map the getTransaction method in the DatabaseTransaction class to the /transaction/{id} address
     * @param id is the transaction id which the data want to be search on the database
     * @return the transaction with specified transaction id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Transaction getTransaction(@PathVariable int id) {
        dt.connect();
        Transaction transaction = dt.getTransaction(id);
        dt.disconnect();
        return transaction;
    }

    /**
     * map the reject method in the DatabaseTransaction class to the /transaction/reject address
     * @param transaction_id is the transaction id which the status want to be changed
     * @return the transaction which status changed
     */
    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public Transaction reject(@RequestParam(value = "transaction_id") int transaction_id){
        dt.connect();
        Transaction transaction = dt.reject(transaction_id);
        dt.disconnect();
        return transaction;
    }

    /**
     * map the accept method in the DatabaseTransaction class to the /transaction/accept address
     * @param transaction_id is the transaction id which the status want to be changed
     * @return the transaction which status changed
     */
    @RequestMapping(value = "/accept", method = RequestMethod.POST)
    public Transaction accept(@RequestParam(value = "transaction_id") int transaction_id){
        dt.connect();
        Transaction transaction = dt.accept(transaction_id);
        dt.disconnect();
        return transaction;
    }

    /**
     * map the finish method in the DatabaseTransaction class to the /transaction/finish address
     * @param transaction_id is the transaction id which the status want to be changed
     * @return the transaction which status changed
     */
    @RequestMapping(value = "/finish", method = RequestMethod.POST)
    public Transaction finish(@RequestParam(value = "transaction_id") int transaction_id){
        dt.connect();
        Transaction transaction = dt.finish(transaction_id);
        dt.disconnect();
        return transaction;
    }

    /**
     * map the getOutgoingHistory method in the DatabaseTransaction class to the /transaction/outgoinghistory/{id} address
     * @param borrower_id is the consumer id which have a role as borrower in the transaction database
     * @return all transactions with status finished or rejected which the borrower id is equal to specified consumer id
     */
    @RequestMapping(value="/outgoinghistory/{borrower_id}", method = RequestMethod.GET)
    public ArrayList<Transaction> getOutgoingHistory (@PathVariable int borrower_id){
        ArrayList<Transaction> transactions = new ArrayList<>();
        dt.connect();
        transactions = dt.getOutgoingHistory(borrower_id);
        dt.disconnect();
        return transactions;
    }

    /**
     * map the getIncomingHistory method in the DatabaseTransaction class to the /transaction/incominghistory/{id} address
     * @param owner_id is the consumer id which owned the book
     * @return all transactions with status rejected or finished which book involved is owned by specified consumer id
     */
    @RequestMapping(value="/incominghistory/{owner_id}", method = RequestMethod.GET)
    public ArrayList<Transaction> getIncomingHistory (@PathVariable int owner_id){
        ArrayList<Transaction> transactions = new ArrayList<>();
        dt.connect();
        transactions = dt.getIncomingHistory(owner_id);
        dt.disconnect();
        return transactions;
    }

}
