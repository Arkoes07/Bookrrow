package com.alpajazel.bookrrow.databases;

import com.alpajazel.bookrrow.enums.BookStatus;
import com.alpajazel.bookrrow.enums.Genre;
import com.alpajazel.bookrrow.enums.Language;
import com.alpajazel.bookrrow.enums.TransactionStatus;
import com.alpajazel.bookrrow.models.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatabaseTransaction extends DatabaseConnection {
    private Consumer getConsumer(int consumerId) throws SQLException {
        Consumer consumer = null;

        int id = 0;
        String username = "", password = "", name = "", email = "", phoneNumber = "";

        PreparedStatement st = getConn().prepareStatement("SELECT * FROM consumer WHERE consumer_id = ?");
        st.setInt(1, consumerId);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            id = rs.getInt("consumer_id");
            username = rs.getString("username");
            password = rs.getString("password");
            name = rs.getString("name");
            email = rs.getString("email");
            phoneNumber = rs.getString("phone_number");
        }
        consumer = new Consumer(id, name, email, username, password, phoneNumber);
        st.close();
        rs.close();
        return consumer;
    }

    private Book getBook(int book_id) throws SQLException {
        Book book = null;
        int year = 0, owner_id = 0;
        String title = "", author = "", description = "", language = "", type = "", genre = "", book_status = "";
        PreparedStatement st = getConn().prepareStatement("SELECT * FROM book where book_id=?;");
        st.setInt(1, book_id);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            title = rs.getString("title");
            author = rs.getString("author");
            description = rs.getString("description");
            language = rs.getString("language");
            year = rs.getInt("year");
            type = rs.getString("type");
            genre = rs.getString("genre");
            owner_id = rs.getInt("owner_id");
            book_status = rs.getString("book_status");
        }
        Consumer consumer = getConsumer(owner_id);
        if (type.equals("FICTION")) {
            book = new Fiction(book_id, title, author, description, Language.valueOf(language), year, BookStatus.valueOf(book_status), consumer, Genre.valueOf(genre));
        } else if (type.equals("NONFICTION")) {
            book = new NonFiction(book_id, title, author, description, Language.valueOf(language), year, BookStatus.valueOf(book_status), consumer);
        }
        return book;
    }

    public Transaction getTransaction(int id) {
        PreparedStatement stmt = null;
        String sql = "select * from transaction where transaction_id = ?";
        try {
            stmt = getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int transactionId = resultSet.getInt("transaction_id");

                int bookId = resultSet.getInt("book_id");
                Book book = getBook(bookId);

                int borrowerId = resultSet.getInt("borrower_id");
                Consumer borrower = getConsumer(borrowerId);

                String transactionStatusRtv = resultSet.getString("transaction_status");
                TransactionStatus transactionStatus = TransactionStatus.valueOf(transactionStatusRtv);

                Date requestDateRtv = resultSet.getDate("request_date");
                Calendar requestDate = new GregorianCalendar();
                requestDate.setTime(requestDateRtv);

                Date startDateRtv = resultSet.getDate("start_date");
                Calendar startDate = new GregorianCalendar();
                if (startDateRtv != null) {
                    startDate.setTime(startDateRtv);
                } else {
                    startDate = null;
                }

                Date finishDateRtv = resultSet.getDate("finish_date");
                Calendar finishDate = new GregorianCalendar();
                if (finishDateRtv != null) {
                    finishDate.setTime(finishDateRtv);
                } else {
                    finishDate = null;
                }

                Transaction transaction = new Transaction(transactionId, book, borrower, transactionStatus, requestDate, startDate, finishDate);
                return transaction;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public ArrayList<Transaction> getIncomingRequest(int id) throws SQLException {
        PreparedStatement stmt = null;
        String sql =
                "select transaction_id,book_id,owner_id,borrower_id,transaction_status,request_date,start_date,finish_date " +
                        "from transaction natural join book " +
                        "where transaction_status = 'PENDING' and owner_id = ?;";

        stmt = getConn().prepareStatement(sql);
        stmt.setInt(1, id);
        ArrayList<Transaction> transactions = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()) {
            int transactionId = resultSet.getInt("transaction_id");

            int bookId = resultSet.getInt("book_id");
            Book book = getBook(bookId);

            int ownerId = resultSet.getInt("owner_id");

            int borrowerId = resultSet.getInt("borrower_id");
            Consumer borrower = getConsumer(borrowerId);

            String transactionStatusRtv = resultSet.getString("transaction_status");
            TransactionStatus transactionStatus = TransactionStatus.valueOf(transactionStatusRtv);

            Date requestDateRtv = resultSet.getDate("request_date");
            Calendar requestDate = new GregorianCalendar();
            requestDate.setTime(requestDateRtv);

            Date startDateRtv = resultSet.getDate("start_date");
            Calendar startDate = new GregorianCalendar();
            if (startDateRtv != null) {
                startDate.setTime(startDateRtv);
            } else {
                startDate = null;
            }

            Date finishDateRtv = resultSet.getDate("finish_date");
            Calendar finishDate = new GregorianCalendar();
            if (finishDateRtv != null) {
                finishDate.setTime(finishDateRtv);
            } else {
                finishDate = null;
            }

            Transaction transaction = new Transaction(transactionId, book, borrower, transactionStatus, requestDate, startDate, finishDate);
            transactions.add(transaction);
        }
        stmt.close();
        return transactions;
    }

    public ArrayList<Transaction> getOutgoingRequest(int id) {
        PreparedStatement stmt = null;
        String sql = "select * from transaction where borrower_id = ? and transaction_status='PENDING';";
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            stmt = getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int transactionId = resultSet.getInt("transaction_id");

                int bookId = resultSet.getInt("book_id");
                Book book = getBook(bookId);

                int borrowerId = resultSet.getInt("borrower_id");
                Consumer borrower = getConsumer(borrowerId);

                String transactionStatusRtv = resultSet.getString("transaction_status");
                TransactionStatus transactionStatus = TransactionStatus.valueOf(transactionStatusRtv);

                Date requestDateRtv = resultSet.getDate("request_date");
                Calendar requestDate = new GregorianCalendar();
                requestDate.setTime(requestDateRtv);

                Date startDateRtv = resultSet.getDate("start_date");
                Calendar startDate = new GregorianCalendar();
                if (startDateRtv != null) {
                    startDate.setTime(startDateRtv);
                } else {
                    startDate = null;
                }

                Date finishDateRtv = resultSet.getDate("finish_date");
                Calendar finishDate = new GregorianCalendar();
                if (finishDateRtv != null) {
                    finishDate.setTime(finishDateRtv);
                } else {
                    finishDate = null;
                }

                Transaction transaction = new Transaction(transactionId, book, borrower, transactionStatus, requestDate, startDate, finishDate);
                transactions.add(transaction);
            }
            stmt.close();
            return transactions;
        } catch (SQLException e) {
            e.printStackTrace();
            return transactions;
        }
    }

    public ArrayList<Transaction> getIncomingOngoing(int id) {
        PreparedStatement stmt = null;
        String sql =
                "select transaction_id,book_id,owner_id,borrower_id,transaction_status,request_date,start_date,finish_date " +
                        "from transaction natural join book " +
                        "where transaction_status='ONGOING' and owner_id=?;";
        try {
            stmt = getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            ArrayList<Transaction> transactions = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int transactionId = resultSet.getInt("transaction_id");

                int bookId = resultSet.getInt("book_id");
                Book book = getBook(bookId);

                int ownerId = resultSet.getInt("owner_id");

                int borrowerId = resultSet.getInt("borrower_id");
                Consumer borrower = getConsumer(borrowerId);

                String transactionStatusRtv = resultSet.getString("transaction_status");
                TransactionStatus transactionStatus = TransactionStatus.valueOf(transactionStatusRtv);

                Date requestDateRtv = resultSet.getDate("request_date");
                Calendar requestDate = new GregorianCalendar();
                requestDate.setTime(requestDateRtv);

                Date startDateRtv = resultSet.getDate("start_date");
                Calendar startDate = new GregorianCalendar();
                if (startDateRtv != null) {
                    startDate.setTime(startDateRtv);
                } else {
                    startDate = null;
                }

                Date finishDateRtv = resultSet.getDate("finish_date");
                Calendar finishDate = new GregorianCalendar();
                if (finishDateRtv != null) {
                    finishDate.setTime(finishDateRtv);
                } else {
                    finishDate = null;
                }

                Transaction transaction = new Transaction(transactionId, book, borrower, transactionStatus, requestDate, startDate, finishDate);
                transactions.add(transaction);
            }
            stmt.close();
            return transactions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getOutgoingOngoing(int id) {
        PreparedStatement stmt = null;
        String sql = "select * from transaction where borrower_id = ? and transaction_status='ONGOING';";
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            stmt = getConn().prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int transactionId = resultSet.getInt("transaction_id");

                int bookId = resultSet.getInt("book_id");
                Book book = getBook(bookId);

                int borrowerId = resultSet.getInt("borrower_id");
                Consumer borrower = getConsumer(borrowerId);

                String transactionStatusRtv = resultSet.getString("transaction_status");
                TransactionStatus transactionStatus = TransactionStatus.valueOf(transactionStatusRtv);

                Date requestDateRtv = resultSet.getDate("request_date");
                Calendar requestDate = new GregorianCalendar();
                requestDate.setTime(requestDateRtv);

                Date startDateRtv = resultSet.getDate("start_date");
                Calendar startDate = new GregorianCalendar();
                if (startDateRtv != null) {
                    startDate.setTime(startDateRtv);
                } else {
                    startDate = null;
                }

                Date finishDateRtv = resultSet.getDate("finish_date");
                Calendar finishDate = new GregorianCalendar();
                if (finishDateRtv != null) {
                    finishDate.setTime(finishDateRtv);
                } else {
                    finishDate = null;
                }

                Transaction transaction = new Transaction(transactionId, book, borrower, transactionStatus, requestDate, startDate, finishDate);
                transactions.add(transaction);
            }
            stmt.close();
            return transactions;
        } catch (SQLException e) {
            e.printStackTrace();
            return transactions;
        }
    }

    public ArrayList<Transaction> getIncomingHistory(int id){
        PreparedStatement stmt = null;
        ArrayList<Transaction> transactions = new ArrayList<>();
        try {
            stmt = getConn().prepareStatement("select transaction_id,book_id,owner_id,borrower_id,transaction_status,request_date,start_date,finish_date from transaction natural join book where (transaction_status='REJECTED' OR transaction_status='FINISHED' ) and owner_id=?;");
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int transactionId = resultSet.getInt("transaction_id");

                int bookId = resultSet.getInt("book_id");
                Book book = getBook(bookId);

                int ownerId = resultSet.getInt("owner_id");

                int borrowerId = resultSet.getInt("borrower_id");
                Consumer borrower = getConsumer(borrowerId);

                String transactionStatusRtv = resultSet.getString("transaction_status");
                TransactionStatus transactionStatus = TransactionStatus.valueOf(transactionStatusRtv);

                Date requestDateRtv = resultSet.getDate("request_date");
                Calendar requestDate = new GregorianCalendar();
                requestDate.setTime(requestDateRtv);

                Date startDateRtv = resultSet.getDate("start_date");
                Calendar startDate = new GregorianCalendar();
                if (startDateRtv != null) {
                    startDate.setTime(startDateRtv);
                } else {
                    startDate = null;
                }

                Date finishDateRtv = resultSet.getDate("finish_date");
                Calendar finishDate = new GregorianCalendar();
                if (finishDateRtv != null) {
                    finishDate.setTime(finishDateRtv);
                } else {
                    finishDate = null;
                }

                Transaction transaction = new Transaction(transactionId, book, borrower, transactionStatus, requestDate, startDate, finishDate);
                transactions.add(transaction);
            }
            stmt.close();
            return transactions;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Transaction> getOutgoingHistory(int borrower_id){
        ArrayList<Transaction> transactions = new ArrayList<>();
        int id=0,book_id=0,transaction_id=0;
        String transaction_status="";
        Transaction transaction = null;
        PreparedStatement st = null;
        try {
            st = getConn().prepareStatement(" SELECT * FROM transaction where borrower_id=? AND (transaction_status='REJECTED' OR transaction_status='FINISHED');");
            st.setInt(1,borrower_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                transaction_id = rs.getInt("transaction_id");
                book_id = rs.getInt("book_id");
                transaction_status = rs.getString("transaction_status");

                Date requestDateRtv = rs.getDate("request_date");
                Calendar requestDate = new GregorianCalendar();
                requestDate.setTime(requestDateRtv);

                Date startDateRtv = rs.getDate("start_date");
                Calendar startDate = new GregorianCalendar();
                if(startDateRtv!=null){
                    startDate.setTime(startDateRtv);
                }else {
                    startDate = null;
                }

                Date finishDateRtv = rs.getDate("finish_date");
                Calendar finishDate = new GregorianCalendar();
                if(finishDateRtv!=null){
                    finishDate.setTime(finishDateRtv);
                }else {
                    finishDate = null;
                }

                Book book = getBook(book_id);
                Consumer consumer = getConsumer(borrower_id);
                transaction = new Transaction(transaction_id, book, consumer, TransactionStatus.valueOf(transaction_status), requestDate, startDate, finishDate);

                transactions.add(transaction);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public Transaction borrow(int book_id, int borrower_id) {
        int id = 0;
        Transaction transaction = null;
        PreparedStatement st = null;
        try {
            st = getConn().prepareStatement("INSERT INTO transaction (book_id, borrower_id) values (?,?) RETURNING transaction_id;");
            st.setInt(1, book_id);
            st.setInt(2, borrower_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
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

    public Transaction accept(int transaction_id){
        int id = 0, book_id=0, borrower_id=0;
        Transaction transaction = null;
        PreparedStatement st = null;
        try {
            st = getConn().prepareStatement("UPDATE transaction set transaction_status = 'ONGOING' where transaction_id=? RETURNING book_id, borrower_id;");
            st.setInt(1,transaction_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                book_id = rs.getInt("book_id");
                borrower_id = rs.getInt("borrower_id");
            }
            Book book = getBook(book_id);
            Consumer consumer = getConsumer(borrower_id);
            transaction = new Transaction(transaction_id, book, consumer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }

    public Transaction finish(int transaction_id){
        int id = 0, book_id=0, borrower_id=0;
        Transaction transaction = null;
        PreparedStatement st = null;
        try {
            st = getConn().prepareStatement("UPDATE transaction set transaction_status = 'FINISHED' where transaction_id=? RETURNING book_id, borrower_id;");
            st.setInt(1,transaction_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                book_id = rs.getInt("book_id");
                borrower_id = rs.getInt("borrower_id");
            }
            Book book = getBook(book_id);
            Consumer consumer = getConsumer(borrower_id);
            transaction = new Transaction(transaction_id, book, consumer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transaction;
    }




}
