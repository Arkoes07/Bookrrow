package com.alpajazel.bookrrow.controller;

import com.alpajazel.bookrrow.databases.DatabaseBook;
import com.alpajazel.bookrrow.enums.BookType;
import com.alpajazel.bookrrow.enums.Genre;
import com.alpajazel.bookrrow.enums.Language;
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

    @RequestMapping("/bylanguage")
    public ArrayList<Book> getAllByLanguage(@RequestParam (value = "language") Language language){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByLanguage(language);
        db.disconnect();
        return books;
    }

    @RequestMapping("/byyear")
    public ArrayList<Book> getAllByYear(@RequestParam (value = "year") int year){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByYear(year);
        db.disconnect();
        return books;
    }

    @RequestMapping("/bygenre")
    public ArrayList<Book> getAllByGenre(@RequestParam (value = "genre") Genre genre){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByGenre(genre);
        db.disconnect();
        return books;
    }

    @RequestMapping("/byauthor")
    public ArrayList<Book> getAllByAuthor(@RequestParam (value = "author") String author){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByAuthor(author);
        db.disconnect();
        return books;
    }

    @RequestMapping("/byowner")
    public ArrayList<Book> getAllByOwner(@RequestParam (value = "owner_id") int ownerId){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByOwner(ownerId);
        db.disconnect();
        return books;
    }

    @RequestMapping("/{book_id}")
    public Book getBookById(@PathVariable int book_id){
        db.connect();
        Book book = db.getBookById(book_id);
        db.disconnect();
        return book;
    }


    @RequestMapping(value = "/insertfiction", method = RequestMethod.POST)
    public Book insertFictionBook(@RequestParam (value = "title") String title,
                                  @RequestParam (value = "author") String author,
                                  @RequestParam (value = "description") String description,
                                  @RequestParam (value = "language") Language language,
                                  @RequestParam (value = "year") int year,
                                  @RequestParam (value = "genre") Genre genre,
                                  @RequestParam (value = "owner_id") int ownerId
                                  )
    {
        db.connect();
        Book book = db.insertBook(title, author, description, language, year, genre, ownerId);
        db.disconnect();
        return book;
    }

    @RequestMapping(value = "/insertnonfiction", method = RequestMethod.POST)
    public Book insertNonFictionBook(@RequestParam (value = "title") String title,
                                     @RequestParam (value = "author") String author,
                                     @RequestParam (value = "description") String description,
                                     @RequestParam (value = "language") Language language,
                                     @RequestParam (value = "year") int year,
                                     @RequestParam (value = "owner_id") int ownerId
    )
    {
        db.connect();
        Book book = db.insertBook(title, author, description, language, year, ownerId);
        db.disconnect();
        return book;
    }

    @RequestMapping(value = "/updatedescription", method = RequestMethod.POST)
    public Book updateBookDescription(@RequestParam (value = "book_id") int bookId,
                                      @RequestParam (value = "description") String description
                                      ){
        db.connect();
        Book book = db.editDescriptionOfBook(bookId, description);
        db.disconnect();
        return book;
    }
}
