package com.alpajazel.bookrrow.controller;

import com.alpajazel.bookrrow.databases.DatabaseTransaction;
import com.alpajazel.bookrrow.models.Book;
import com.alpajazel.bookrrow.models.Consumer;
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
        return transactions;
    }

//    @RequestMapping(value = "/reject", method = RequestMethod.POST)
//    public Transaction reject(@RequestParam(value = "transaction_id") int transaction_id)
    @RequestMapping(value = "/reject", method = RequestMethod.POST)
    public Transaction reject(@RequestParam(value = "transaction_id") int transaction_id){
        dt.connect();
        Transaction transaction = dt.reject(transaction_id);
        dt.disconnect();
        return transaction;
    }
}
