package com.alpajazel.bookrrow.models;

import com.alpajazel.bookrrow.enums.BookStatus;
import com.alpajazel.bookrrow.enums.BookType;
import com.alpajazel.bookrrow.enums.Genre;
import com.alpajazel.bookrrow.enums.Language;

/**
 * Represent the Fiction type of book.
 * Book with type Fiction have a genre.
 *
 * @author M. Alwi Sukra
 * @version 1.0.0
 * @since 2019-05-10
 */
public class Fiction extends Book {
    private Genre genre;

    /**
     * Contructor for Fiction
     *
     * @param id this book id
     * @param title this book title
     * @param author this book author name
     * @param description description of this book
     * @param language language written in this book
     * @param year this book released year
     * @param status status that tells the availability of this book to be lent
     * @param owner this book owner
     * @param genre this book genre
     */
    public Fiction(int id, String title, String author, String description, Language language, int year, BookStatus status, Consumer owner, Genre genre) {
        super(id, title, author, description, language, year, BookType.FICTION, status, owner);
        this.genre = genre;
    }

    /**
     * Get the genre of this book
     *
     * @return the genre of this book
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Genereate string that contains the information of this object
     *
     * @return string that contains the information of this object
     * @since 2019-05-17
     */
    @Override
    public String toString() {
        return  "id : "             + this.getId() +
                "title : "          + this.getTitle() +
                "author : "         + this.getAuthor() +
                "description : "    + this.getDescription() +
                "language : "       + this.getLanguage() +
                "year : "           + this.getYear() +
                "status : "         + this.getStatus() +
                "owner : "          + this.getOwner() +
                "genre : "          + this.getGenre();
    }
}
