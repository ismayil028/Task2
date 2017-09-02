package com.ismayil.database;

import java.sql.*;

public class DatabaseQosulma {

    private static final String URL = "jdbc:mysql://localhost:3306/mydata?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String CLASSNAME = "com.mysql.jdbc.Driver";

    private static Connection con;

    public static Connection getConnection() {
        con = null;
        try {
            Class.forName(CLASSNAME);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return con;

    }

    public static Statement getStatement() {
        Statement stmt = null;
        try {
            
            stmt = getConnection().createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return stmt;
    }

    public static PreparedStatement getPreparedStatement(String query) {
        PreparedStatement ps = null;
        try {
            ps = getConnection().prepareStatement(query);
            
        } catch (SQLException e) {
            System.out.println(e);
        }

        return ps;

    }
}