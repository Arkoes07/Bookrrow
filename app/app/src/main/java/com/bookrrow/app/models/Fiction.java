package com.bookrrow.app.models;

import com.bookrrow.app.enums.BookType;
import com.bookrrow.app.enums.Genre;
import com.bookrrow.app.enums.Language;

public class Fiction extends Book {
    private static final BookType BOOK_TYPE = BookType.FICTION;
    private Genre genre;

    public Fiction(String title, String subtitle, Genre genre, Author author, Language language, int year, User user) {
        super(title, subtitle, author, language, year, user);
        this.genre = genre;
    }

    @Override
    public BookType getType() {
        return BOOK_TYPE;
    }

    @Override
    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        String status;
        if(super.isStatus()){
            status = "Available";
        }
        else{
            status = "Borrowed";
        }
        return "\nID: "+super.getId()+
                "\nTitle: "+super.getTitle()+
                ": "+super.getSubtitle()+
                "\nType: "+this.getType()+
                "\nGenre: "+this.getGenre()+
                "\nAuthor: "+super.getAuthor().getName()+
                "\nLanguage: "+super.getLanguage()+
                "\nReleased Year: "+super.getYear()+
                "\nStatus: "+status+
                "\nFrom User: "+super.getUser();
    }
}
