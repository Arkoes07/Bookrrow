package com.bookrrow.app.models;

import com.bookrrow.app.enums.BookType;
import com.bookrrow.app.enums.Genre;
import com.bookrrow.app.enums.Language;
import com.bookrrow.app.databases.DatabaseBook;

public abstract class Book {
    private int id;
    private String title;
    private String subtitle;
    private Author author;
    private Language language;
    private int year;
    private BookType type;
    private boolean status;
    private User user;
    private Genre genre;

    public Book(String title, String subtitle, Author author, Language language, int year, User user) {
        this.id = DatabaseBook.getLastBookId()+1;
        this.title = title;
        this.subtitle = subtitle;
        this.author = author;
        this.language = language;
        this.year = year;
        this.status = true;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Author getAuthor() {
        return author;
    }

    public Language getLanguage() {
        return language;
    }

    public int getYear() {
        return year;
    }

    public abstract BookType getType();

    public boolean isStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public abstract Genre getGenre();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public abstract String toString();
}
