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

    /**
     * Get list of all Book objects in the book table in postgresql.
     *
     * @return all Books from book table as an array list of Book object
     * @since 2019-05-10
     */
    @RequestMapping("")
    public ArrayList<Book> getAll(){
        db.connect();
        ArrayList<Book> books = db.getAllBooks();
        db.disconnect();
        return books;
    }

    /**
     * Get list of all Book objects in the book table in postgresql with available status.
     *
     * @return all Books from book table with available status as an array list of Book object
     * @since 2019-05-10
     */
    @RequestMapping("/")
    public ArrayList<Book> getAllAvailable(){
        db.connect();
        ArrayList<Book> books = db.getAllAvailableBooks();
        db.disconnect();
        return books;
    }

    /**
     * Get list of all Book objects in the book table in postgresql that have a title like parameter given and available.
     *
     * @param title will be specified in the SQL query to narrow down the result
     * @return all books from book table which have title like parameter given and available as an array list
     * @since 2019-05-11
     */
    @RequestMapping("/bytitle")
    public ArrayList<Book> getAllByTitle(@RequestParam (value = "title") String title){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByTitle(title);
        db.disconnect();
        return books;
    }

    /**
     * Get list of all Book objects in the book table in postgresql with specific type and available.
     *
     * @param bookType will be specified in the SQL query to narrow down the result
     * @return all books from book table which have the specified type and available as an array list
     * @since 2019-05-10
     */
    @RequestMapping("/bytype")
    public ArrayList<Book> getAllByType(@RequestParam (value = "type") BookType bookType){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByType(bookType);
        db.disconnect();
        return books;
    }

    /**
     * Get list of all Book objects in the book table in postgresql with specific language and available.
     *
     * @param language will be specified in the SQL query to narrow down the result
     * @return all books from book table which have the specified language and available as an array list
     * @since 2019-05-10
     */
    @RequestMapping("/bylanguage")
    public ArrayList<Book> getAllByLanguage(@RequestParam (value = "language") Language language){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByLanguage(language);
        db.disconnect();
        return books;
    }

    /**
     * Get list of all Book objects in the book table in postgresql with specific released year and available.
     *
     * @param year will be specified in the SQL query to narrow down the result
     * @return all books from book table which have the specified year and available as an array list
     * @since 2019-05-10
     */
    @RequestMapping("/byyear")
    public ArrayList<Book> getAllByYear(@RequestParam (value = "year") int year){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByYear(year);
        db.disconnect();
        return books;
    }

    /**
     * Get list of all Book objects in the book table in postgresql with specific genre and available.
     *
     * @param genre will be specified in the SQL query to narrow down the result
     * @return all books from book table which have the specified genre and available as an array list
     * @since 2019-05-10
     */
    @RequestMapping("/bygenre")
    public ArrayList<Book> getAllByGenre(@RequestParam (value = "genre") Genre genre){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByGenre(genre);
        db.disconnect();
        return books;
    }

    /**
     * Get list of all Book objects in the book table in postgresql that have an author name like parameter given and available.
     *
     * @param author will be specified in the SQL query to narrow down the result
     * @return all books from book table which have author name like parameter given and available as an array list
     * @since 2019-05-10
     */
    @RequestMapping("/byauthor")
    public ArrayList<Book> getAllByAuthor(@RequestParam (value = "author") String author){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByAuthor(author);
        db.disconnect();
        return books;
    }

    /**
     * Get list of all Book objects in the book table in postgresql with specific owner id.
     *
     * @param ownerId will be specified in the SQL query to narrow down the result
     * @return all books from book table which have the specified owner id as an array list
     * @since 2019-05-10
     */
    @RequestMapping("/byowner")
    public ArrayList<Book> getAllByOwner(@RequestParam (value = "owner_id") int ownerId){
        db.connect();
        ArrayList<Book> books = db.getAllBooksByOwner(ownerId);
        db.disconnect();
        return books;
    }

    /**
     * Get Book object from the book table in postgresql with specific book id in the path variable.
     *
     * @return Book object from book table that have the specified book id
     * @since 2019-05-10
     */
    @RequestMapping("/{book_id}")
    public Book getBookById(@PathVariable int book_id){
        db.connect();
        Book book = db.getBookById(book_id);
        db.disconnect();
        return book;
    }

    /**
     * Insert Fiction Book Object to the book table in postgresql
     *
     * @param title the title of the book
     * @param author the author of the book
     * @param description the description of the book
     * @param language the language of the book
     * @param year the released year of the book
     * @param genre the genre of the book
     * @param ownerId the id of the owner of the book
     * @return the Book object that successfully inserted to the book table in postgresql
     * @since 2019-05-11
     */
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

    /**
     * Insert NonFiction Book Object to the book table in postgresql
     *
     * @param title the title of the book
     * @param author the author of the book
     * @param description the description of the book
     * @param language the language of the book
     * @param year the released year of the book
     * @param ownerId the id of the owner of the book
     * @return the Book object that successfully inserted to the book table in postgresql
     * @since 2019-05-11
     */
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

    /**
     * update description of one book with the specified book id
     *
     * @param bookId the id of the book to select one book to be updated
     * @param description the new description of the book
     * @return the Book object that successfully updated to the book table in postgresql
     * @since 2019-05-11
     */
    @RequestMapping(value = "/updatedescription", method = RequestMethod.POST)
    public Book updateBookDescription(@RequestParam (value = "book_id") int bookId,
                                      @RequestParam (value = "description") String description
                                      ){
        db.connect();
        Book book = db.editDescriptionOfBook(bookId, description);
        db.disconnect();
        return book;
    }

    /**
     * Delete a book with specified book id
     *
     * @param bookId the id of the book to be deleted
     * @return the Book Object that successfully deleted from the book table in postgresql
     * @since 2019-05-12
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Book deleteABook(@RequestParam (value = "book_id") int bookId ){
        db.connect();
        Book book = db.deleteBook(bookId);
        db.disconnect();
        return book;
    }
}
