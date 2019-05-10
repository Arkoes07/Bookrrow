package com.alpajazel.bookrrow.databases;

import com.alpajazel.bookrrow.enums.TransactionStatus;
import com.alpajazel.bookrrow.models.Book;
import com.alpajazel.bookrrow.models.Consumer;
import com.alpajazel.bookrrow.models.Transaction;

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

    public ArrayList<Transaction> getIncomingRequest (int id) throws SQLException {
        PreparedStatement stmt = null;
        String sql = "select transaction_id,book_id,owner_id,borrower_id,transaction_status,request_date,start_date,finish_date"+
                " from transaction natural join book "+
                "where transaction_status='PENDING' and owner_id=?;";

        stmt = getConn().prepareStatement(sql);
        stmt.setInt(1,id);
        ArrayList<Transaction> transactions = new ArrayList<>();
        ResultSet resultSet = stmt.executeQuery();
        while (resultSet.next()){
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
            startDate.setTime(startDateRtv);

            Date finishDateRtv = resultSet.getDate("finish_date");
            Calendar finishDate = new GregorianCalendar();
            finishDate.setTime(finishDateRtv);

            Transaction transaction = new Transaction(transactionId,book,borrower,transactionStatus,requestDate,startDate,finishDate);
            transactions.add(transaction);
        }
        return transactions;
    }


}

//    private static final ArrayList<Transaction> TRANSACTION_DATABASE = new ArrayList<>();
//    private static int LAST_TRANSACTION_ID = 0;
//
//    public static int getLastTransactionId() {
//        return LAST_TRANSACTION_ID;
//    }
//
//    public static boolean addTransaction(Transaction transaction) throws BookAlreadyExistsException {
//        TRANSACTION_DATABASE.add(transaction);
//        LAST_TRANSACTION_ID = transaction.getTransaction_id();
//        return true;
//    }
//
//    public static Transaction getTransactionFromId(int transaction_id){
//        for(Transaction t : TRANSACTION_DATABASE){
//            if(t.getTransaction_id() == transaction_id){
//                return t;
//            }
//        }
//        return null;
//    }
