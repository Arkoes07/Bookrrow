package com.bookrrow.app.databases;

import com.bookrrow.app.enums.BookType;
import com.bookrrow.app.enums.Genre;
import com.bookrrow.app.enums.Language;
import com.bookrrow.app.exceptions.BookAlreadyExistsException;
import com.bookrrow.app.exceptions.BookNotFoundException;
import com.bookrrow.app.models.Author;
import com.bookrrow.app.models.Book;
import com.bookrrow.app.models.User;

import java.util.ArrayList;

public class DatabaseBook {
    private static int LAST_BOOK_ID = 0;
    private static final ArrayList<Book> BOOK_DATABASE = new ArrayList<>();

    public static int getLastBookId() {
        return LAST_BOOK_ID;
    }

    public static boolean addBook(Book book) throws BookAlreadyExistsException {
        for(Book b : BOOK_DATABASE){
            if(b.getTitle().equals(book.getTitle()) && b.getSubtitle().equals(book.getSubtitle()) && b.getUser().equals(book.getUser())){
                throw new BookAlreadyExistsException(b);
            }
        }
        BOOK_DATABASE.add(book);
        LAST_BOOK_ID = book.getId();
        return true;
    }

    public static Book getBookFromId(int id){
        for(Book b : BOOK_DATABASE){
            if(id == b.getId()){
                return b;
            }
        }
        return null;
    }

    public static ArrayList<Book> getBookFromTitle(String title){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(b.getTitle().equals(title)){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getBookFromUser(User user){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(user.equals(b.getUser())){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getAvailableBookFromUser(User user){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(user.equals(b.getUser()) && b.isStatus()){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getUnvailableBookFromUser(User user){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(user.equals(b.getUser()) && !b.isStatus()){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getBookFromAuthor(Author author){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(author.equals(b.getAuthor())){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getAvailableBookFromAuthor(Author author){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(author.equals(b.getAuthor()) && b.isStatus()){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getBookFromType(BookType type){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(type.equals(b.getType())){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getAvailableBookFromType(BookType type){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(type.equals(b.getType()) && b.isStatus()){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getFictionBookFromGenre(Genre genre){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(b.getType()== BookType.FICTION && genre.equals(b.getGenre())){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getAvailableFictionBookFromGenre(Genre genre){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(b.getType()== BookType.FICTION && genre.equals(b.getGenre()) && b.isStatus()){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getBookFromYear(int year){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(b.getYear()==year){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getAvailableBookFromYear(int year){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(b.getYear()==year && b.isStatus()){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getBookFromLanguage(Language language){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(b.getLanguage().equals(language)){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getAvailableBookFromLanguage(Language language){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(b.getLanguage().equals(language) && b.isStatus()){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getAllAvailableBook(){
        ArrayList<Book> temp = new ArrayList<>();
        for(Book b : BOOK_DATABASE){
            if(b.isStatus()){
                temp.add(b);
            }
        }
        if(temp.size()>0){
            return temp;
        }
        else{
            return null;
        }
    }

    public static ArrayList<Book> getBookDatabase() {
        return BOOK_DATABASE;
    }

    public static boolean removeItem(int id) throws BookNotFoundException {
        for(Book b : BOOK_DATABASE){
            if(id == b.getId()){
                BOOK_DATABASE.remove(b);
                return true;
            }
        }
        throw new BookNotFoundException(id);
    }
}
