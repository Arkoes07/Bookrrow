package com.bookrrow.app.models;

import com.bookrrow.app.enums.BookType;
import com.bookrrow.app.enums.Genre;
import com.bookrrow.app.enums.Language;

public class NonFiction extends Book {
    private static final BookType BOOK_TYPE = BookType.NONFICTION;

    public NonFiction(String title, String subtitle, Author author, Language language, int year, User user) {
        super(title, subtitle, author, language, year, user);
    }

    @Override
    public BookType getType() {
        return BOOK_TYPE;
    }

    @Override
    public Genre getGenre() {
        return null;
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
                "\nAuthor: "+super.getAuthor().getName()+
                "\nLanguage: "+super.getLanguage()+
                "\nReleased Year: "+super.getYear()+
                "\nStatus: "+status+
                "\nFrom User: "+super.getUser();
    }
}
