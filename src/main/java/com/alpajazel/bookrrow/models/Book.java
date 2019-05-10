package com.alpajazel.bookrrow.models;

import com.alpajazel.bookrrow.enums.BookStatus;
import com.alpajazel.bookrrow.enums.BookType;
import com.alpajazel.bookrrow.enums.Language;

/**
 * Represent a book in general.
 * this class cannot be instantiate because book will be divided into 2 type.
 *
 * @author M. Alwi Sukra
 * @version 1.0
 * @since 2019-05-10
 */
public abstract class Book {
    private int id;
    private String title;
    private String author;
    private String description;
    private Language language;
    private int year;
    private BookType type;
    private BookStatus status;
    private Consumer owner;

    /**
     * Constructor that will be invoked by the sub class
     *
     * @param id this book id
     * @param title this book title
     * @param author this book author name
     * @param description description of this book
     * @param language language written in this book
     * @param year this book released year
     * @param type type of the book, which is Fiction or Non-Fiction
     * @param status status that tells the availability of this book to be lent
     * @param owner this book owner
     */
    public Book(int id, String title, String author, String description, Language language, int year, BookType type, BookStatus status, Consumer owner) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.language = language;
        this.year = year;
        this.type = type;
        this.status = status;
        this.owner = owner;
    }

    /**
     * Get the id of this book
     *
     * @return the id of this book
     * @since 2019-05-10
     */
    public int getId() {
        return id;
    }

    /**
     * Get the title of this book
     *
     * @return the title of this book
     * @since 2019-05-10
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the author of this book
     *
     * @return the author of this book
     * @since 2019-05-10
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Get the description of this book
     *
     * @return the description of this book
     * @since 2019-05-10
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the language of this book
     *
     * @return the language of this book
     * @since 2019-05-10
     */
    public Language getLanguage() {
        return language;
    }

    /**
     * Get the released year of this book
     *
     * @return the released year of this book
     * @since 2019-05-10
     */
    public int getYear() {
        return year;
    }

    /**
     * Get the type of this book whether is fiction or non-fiction
     *
     * @return the type of this book
     * @since 2019-05-10
     */
    public BookType getType() {
        return type;
    }

    /**
     * Get status of this book whether is available or not available to be borrowed
     *
     * @return the status of this book
     * @since 2019-05-10
     */
    public BookStatus getStatus() {
        return status;
    }

    /**
     * Get the consumer object of the owner of this book
     *
     * @return the consumer object of the owner of this book
     * @since 2019-05-10
     */
    public Consumer getOwner() {
        return owner;
    }
}
