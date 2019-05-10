package com.alpajazel.bookrrow.databases;

import java.sql.*;

/**
 * Class for connecting to postgresql server using jdbc
 * Subclass from this class will have a connection object and will be able to connect and disconnect with postgresql server
 *
 * @author M. Alwi Sukra
 * @version 1.0
 * @since 2019-05-10
 */
public class DatabaseConnection {
    private Connection conn = null;

    /**
     * Method for connecting to PostgreSQL
     *
     * @since 2019-05-10
     */
    public void connect(){
        try {
            String jdbURL = "jdbc:postgresql://localhost:5432/bookrrow";
            String username = "postgres";
            String password = "";
            conn = DriverManager.getConnection(jdbURL, username, password);
            System.out.println("Database Connection Established");
        } catch (SQLException e) {
//            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    /**
     * Method for disconnecting from postgresql
     *
     * @since 2019-05-10
     */
    public void disconnect(){
        try {
            if(conn != null){
                conn.close();
            }
            System.out.println("Database Connection Terminated");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }
    }

    /**
     * Get the jdbc connection object
     *
     * @return the jdbc connection object
     * @since 2019-05-10
     */
    public Connection getConn() {
        return conn;
    }
}
