package com.alpajazel.bookrrow.databases;

import com.alpajazel.bookrrow.enums.BookStatus;
import com.alpajazel.bookrrow.enums.BookType;
import com.alpajazel.bookrrow.enums.Genre;
import com.alpajazel.bookrrow.enums.Language;
import com.alpajazel.bookrrow.exceptions.BookAlreadyExistsException;
import com.alpajazel.bookrrow.models.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;import java.util.ArrayList;

public class DatabaseTransaction extends DatabaseConnection {
    private Consumer getConsumer(int consumerId) throws SQLException {
        Consumer consumer = null;

        int id = 0;
        String username = "", password = "", name = "", email = "", phoneNumber = "";

        PreparedStatement st = getConn().prepareStatement("SELECT * FROM consumer WHERE consumer_id = ?");
        st.setInt(1,consumerId);
        ResultSet rs = st.executeQuery();
        while (rs.next()){
            id = rs.getInt("consumer_id");
            username = rs.getString("username");
            password = rs.getString("password");
            name = rs.getString("name");
            email = rs.getString("email");
            phoneNumber = rs.getString("phone_number");
        }
        consumer = new Consumer(id,name,email,username,password,phoneNumber);
        st.close();
        rs.close();
        return consumer;
    }

    private Book getBook(int book_id) throws SQLException {
        Book book = null;
        int year=0, owner_id=0;
        String title="", author="", description="",language="",type="",genre="",book_status="";
        PreparedStatement st = getConn().prepareStatement("SELECT * FROM book where book_id=?;");
        st.setInt(1,book_id);
        ResultSet rs = st.executeQuery();
        while(rs.next()){
            title = rs.getString("title");
            author = rs.getString("author");
            description = rs.getString("description");
            language = rs.getString("language");
            year = rs.getInt("year");
            type =rs.getString("type");
            genre = rs.getString("genre");
            owner_id = rs.getInt("owner_id");
            book_status = rs.getString("book_status");
        }
        Consumer consumer = getConsumer(owner_id);
        if(type.equals("FICTION")){
            book = new Fiction(book_id, title, author, description, Language.valueOf(language), year, BookStatus.valueOf(book_status), consumer, Genre.valueOf(genre));
        }
        else if(type.equals("NONFICTION")){
            book = new NonFiction(book_id, title, author, description, Language.valueOf(language),year, BookStatus.valueOf(book_status),consumer);
        }
        return book;
    }

    public Transaction borrow(int book_id, int borrower_id) {
        int id = 0;
        Transaction transaction = null;
        PreparedStatement st = null;
        try {
            st = getConn().prepareStatement("INSERT INTO transaction (book_id, borrower_id) values (?,?) RETURNING transaction_id;");
            st.setInt(1,book_id);
            st.setInt(2, borrower_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                id = rs.getInt("transaction_id");
            }
            Book book = getBook(book_id);
            Consumer consumer = getConsumer(borrower_id);
            transaction = new Transaction(id, book, consumer);
            st.close();
            rs.close();
            return transaction;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }


}
