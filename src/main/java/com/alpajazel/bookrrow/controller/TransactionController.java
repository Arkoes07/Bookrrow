package com.alpajazel.bookrrow.controller;

import com.alpajazel.bookrrow.databases.DatabaseTransaction;
import com.alpajazel.bookrrow.models.Book;
import com.alpajazel.bookrrow.models.Consumer;
import com.alpajazel.bookrrow.models.Transaction;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/transaction")
public class TransactionController {
    DatabaseTransaction dt = new DatabaseTransaction();

    @RequestMapping(value="/borrow", method = RequestMethod.POST)
    public Transaction borrow(@RequestParam(value="book_id") int book_id,
                              @RequestParam(value="borrower_id") int borrower_id
    ) throws SQLException {
        dt.connect();
        Transaction transaction = dt.borrow(book_id, borrower_id);
        dt.disconnect();
        return transaction;
    }
}
