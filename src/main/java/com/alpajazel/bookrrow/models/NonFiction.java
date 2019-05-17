package com.alpajazel.bookrrow.models;

import com.alpajazel.bookrrow.enums.BookStatus;
import com.alpajazel.bookrrow.enums.BookType;
import com.alpajazel.bookrrow.enums.Language;

/**
 * Represent the NonFiction type of book.
 * Book with type NonFiction does not have a genre.
 *
 * @author M. Alwi Sukra
 * @version 1.0.0
 * @since 2019-05-10
 */
public class NonFiction extends Book {

    /**
     * Constructor for NonFiction
     *
     * @param id this book id
     * @param title this book title
     * @param author this book author name
     * @param description description of this book
     * @param language language written in this book
     * @param year this book released year
     * @param status status that tells the availability of this book to be lent
     * @param owner this book owner
     */
    public NonFiction(int id, String title, String author, String description, Language language, int year, BookStatus status, Consumer owner) {
        super(id, title, author, description, language, year, BookType.NONFICTION, status, owner);
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
                "owner : "          + this.getOwner();
    }
}
