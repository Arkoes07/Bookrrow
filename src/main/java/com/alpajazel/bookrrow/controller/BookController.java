package com.alpajazel.bookrrow.controller;

import com.alpajazel.bookrrow.databases.DatabaseBook;
import com.alpajazel.bookrrow.enums.BookType;
import com.alpajazel.bookrrow.models.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Controller Class that handle request that related to DatabaseBook class
 *
 * @author M. Alwi Sukra
 * @version 1.0.0
 * @since 2019-05-10
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/book")
public class BookController {
    private DatabaseBook db = new DatabaseBook();

    @RequestMapping("")
    public ArrayList<Book> getAll(){
        db.connect();
        ArrayList<Book> books = db.getAllBooks();
        db.disconnect();
        return books;
    }

    @RequestMapping("/")
    public ArrayList<Book> getAllAvailable(){
        db.connect();
        ArrayList<Book> books = db.getAllAvailableBooks();
        db.disconnect();
        return books;
    }

    @RequestMapping("/bytype")
    public ArrayList<Book> getAllByType(@RequestParam (value = "type") BookType bookType){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByType(bookType);
        db.disconnect();
        return books;
    }

}
